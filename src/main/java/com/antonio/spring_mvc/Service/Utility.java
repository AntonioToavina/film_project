package com.antonio.spring_mvc.Service;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static List<FieldUtil> getFields(Object o) throws Exception {
        Field[] fields = o.getClass().getDeclaredFields();

        ArrayList<FieldUtil> result = new ArrayList<>();
        for (Field field : fields) {

                result.add(new FieldUtil(field.getName(), getFieldValue(field.getName(), o)));

        }
        return result;

    }

    private static Object getFieldValue(String fieldName, Object o) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, IntrospectionException, NoSuchFieldException, InstantiationException {

        PropertyDescriptor pd = null;

        Method m = null;
        Object r = null;
        try {
            pd = new PropertyDescriptor(fieldName, o.getClass());
            m = pd.getReadMethod();

            r = m.invoke(o);


        } catch (SecurityException | IllegalAccessException | InvocationTargetException e) {
            throw e;
        }
        return r;
    }
    public static void createCriterion(Object o, Criteria criteria, String logical_operation) throws Exception{
        try {
            List<FieldUtil> fields=getFields(o);
            List<Criterion> criterions=new ArrayList<>();
            for (FieldUtil field : fields) {
                if(field.getValue()!=null){
                    if(field.getValue().getClass().equals(Integer.class) || field.getValue().getClass().equals(Double.class)){
                        if(field.getValue().toString().equals("0") || field.getValue().toString().equals("0.0"))
                            continue;
                    }
                    Criterion c= Restrictions.eq(field.getFieldName(),field.getValue());

                    if(field.getValue().getClass().equals(String.class))
                        c=Restrictions.ilike(field.getFieldName(),"%"+field.getValue()+"%");

                    criterions.add(c);
                }
            }
            setCriteria(criteria,criterions,logical_operation);
        } catch (Exception ex) {
            throw ex;
        }
    }

    private static void setCriteria(Criteria criteria,List<Criterion> criterionList,String logical_operation){

        int size=criterionList.size();
        if (size > 0) {
            if (size == 1) {
                criteria.add(criterionList.get(0));
            } else {
                int i = 0;
                while (i < size - 1) {
                    if(logical_operation.equals("or"))
                        criteria.add(Restrictions.or(criterionList.get(i), criterionList.get(i + 1)));
                    else
                        criteria.add(Restrictions.and(criterionList.get(i), criterionList.get(i + 1)));
                    i += 2;
                }
                if (size % 2 != 0) {
                    criteria.add(criterionList.get(size - 1));
                }
            }
        }
    }

    public static String formatDate(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(date);
    }

    public static String formatTimestamp(Timestamp time){
        if(time==null)
            return "";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return sdf.format(time);
    }
}
