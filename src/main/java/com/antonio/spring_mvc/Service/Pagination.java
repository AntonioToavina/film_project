package com.antonio.spring_mvc.Service;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.LimitPage;

import java.util.List;

public class Pagination {
    public static int nbResultSet=0;
    public static int currPage=1;
    public static int start=0;
    public static int limit=0;


    public void initPagination(HibernateDAO dao,Object obj){
        if(Pagination.nbResultSet==0){
            Pagination.limit=30;
            List<Object> list=dao.find(obj,true,Pagination.start,Pagination.limit);
            Pagination.nbResultSet=list.size();
        }
        Pagination.start=0;;
        Pagination.limit=getLimit(dao);
        Pagination.currPage=1;
    }


    public int getLimit(HibernateDAO dao){
        LimitPage limitPage=new LimitPage();
        limitPage.setId(1);
        limitPage=(LimitPage)dao.findById(limitPage);
        if(limitPage==null)
            return 0;

        return limitPage.getValeur();
    }

    public void nextPage(int increment,HibernateDAO dao,Object obj){
        Pagination.start=Pagination.start+(increment*getLimit(dao));
        if(Pagination.start>=Pagination.nbResultSet || Pagination.start<=0)
            initPagination(dao,obj);
        else
            Pagination.currPage=Pagination.currPage+increment;
    }


}
