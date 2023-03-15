package com.antonio.spring_mvc.DAO;

import com.antonio.spring_mvc.Service.Pagination;
import com.antonio.spring_mvc.Service.Utility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HibernateDAO implements InterfaceDAO{
    Session session;
    Transaction transaction;

    private SessionFactory factory;

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public void generateFactory(){
        try{
            Configuration conf=new Configuration();
            factory = conf.configure().buildSessionFactory();
        }catch(Exception e){
            System.out.println("Error generateFactory");
            e.printStackTrace();
        }
    }

    public SessionFactory getFactory() {
        if(factory==null) {
            try {
                generateFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return factory;
    }


    public void closeSession(){
        if(this.session!=null)
            this.session.close();
    }

    public void openConnection(){
        try{
            this.session=getFactory().openSession();
            this.transaction = this.session.beginTransaction();
        }catch(Throwable e){
            System.out.println(e);
        }
    }

    public String getTableName(Object obj){
        return obj.getClass().getSimpleName();
    }

    public ArrayList<Object> convertList(List<Object> list){
        ArrayList<Object> array=new ArrayList<>();
        for(Iterator iterator = list.iterator(); iterator.hasNext();){
            array.add(iterator.next());
        }
        return array;
    }

    @Override
    public List<Object> findAll(Object obj){
        this.transaction = null;
        this.session=null;
        List<Object> results=null;

        try{
            openConnection();
            Criteria cr=this.session.createCriteria(obj.getClass());
            System.out.println("atooo");
            System.out.println(cr.list().size());
            results=cr.list();
        }catch(Exception e ){
            e.printStackTrace();
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        }finally{
            closeSession();
        }
        System.out.println(results.size());
        return results;
    }

    @Override
    public void save(Object obj) {
        this.transaction = null;
        this.session=null;

        try {
            openConnection();
            this.session.save(obj);
            this.transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        }finally{
            closeSession();
        }
    }

    @Override
    public void update(Object obj){
        this.transaction = null;
        this.session=null;

        try{
            openConnection();
            this.session.update(obj);
            this.transaction.commit();
        }catch(Exception e){
            if (this.transaction != null)
                this.transaction.rollback();

        }finally {
            closeSession();
        }
    }

    @Override
    public void delete(Object obj){
        this.transaction = null;
        this.session=null;

        try{
            openConnection();
            this.session.delete(obj);
            this.transaction.commit();
        }catch(Exception e){
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        }finally {
            closeSession();
        }
    }

    @Override
    public List<Object> find(Object o,boolean all,int start,int limit)  {
        this.transaction = null;
        this.session=null;
        try {
            openConnection();
            Criteria criteria=session.createCriteria(o.getClass());
            Utility.createCriterion(o,criteria,"and");
            if(!all){
                System.out.println("Start="+Pagination.start);
                System.out.println("Limit="+Pagination.limit);
                criteria.setFirstResult(start);
                criteria.setMaxResults(limit);
            }
            return criteria.list();
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            closeSession();
        }
        return null;
    }

    @Override
    public Object findById(Object obj) {
        this.transaction = null;
        this.session=null;
        try{
            openConnection();
            Criteria criteria=session.createCriteria(obj.getClass());
            Utility.createCriterion(obj,criteria,"and");
            return criteria.list().get(0);
        }catch(Exception e){
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        }finally {
            closeSession();
        }
        return null;
    }
}
