package com.antonio.spring_mvc.Service;

import com.antonio.spring_mvc.DAO.HibernateDAO;

import java.util.List;

public class TableSearch {
    String tableName;
    String columnRef;
    String check;
    boolean encapsulate = false;

    public boolean isEncapsulate() {
        return encapsulate;
    }

    public void setEncapsulate(boolean encapsulate) {
        this.encapsulate = encapsulate;
    }

    public String getCheck() {
        return check;
    }
    public void setCheck(String check) {
        this.check = check;
    }
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnRef() {
        return columnRef;
    }

    public void setColumnRef(String columnRef) {
        this.columnRef = columnRef;
    }

    public String identifyMostLikely(HibernateDAO linkedSql, String[] words) throws Exception {
        boolean flag = false;
        StringBuilder queryBuilder = new StringBuilder();
        for(String word : words){
            List temp = linkedSql.broadRequest("SELECT * FROM "+tableName+" where "+columnRef+" "+check+" "+encapsulateWord(word),null);
            if(temp.size()>0){
                if(!flag){
                    queryBuilder.append(" and ( false");
                    flag = true;
                }

                queryBuilder.append(" or "+columnRef+" "+check+" "+encapsulateWord(word));
            }
        }

        if(flag)
            queryBuilder.append(")");
        return queryBuilder.toString();
    }

    public String format(String keyword){
        return " and "+columnRef+" "+check+" "+encapsulateWord(keyword);
    }

    public String encapsulateWord(String word){
        if(encapsulate)
            return "'%"+word+"%'";

        else
            return "'"+word+"'";
    }

    public TableSearch(String table, String column, String contraintes){
        tableName = table;
        columnRef = column;
        check = contraintes;
    }
}
