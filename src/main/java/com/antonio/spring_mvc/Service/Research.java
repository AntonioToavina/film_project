package com.antonio.spring_mvc.Service;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.Scene;

import javax.persistence.Query;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Research {
    TableSearch[] tableSearch;

    public Research(){
        tableSearch = new TableSearch[3];
        tableSearch[0] = new TableSearch("color","colorname","ilike");
        tableSearch[1] = new TableSearch("categorie_value","designation","ilike");

        tableSearch[2] = new TableSearch("produit","nom","ilike");
        tableSearch[2].setEncapsulate(true);
    }


    public String formatResearch(HibernateDAO linkedSql,String fullText) throws Exception {
//        Explode the text in word
        String[] words = fullText.split(" ");
        Research research = new Research();
        int counter = 0;

        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM v_sous_produit_details WHERE true ");
//
//        for(TableSearch table : research.tableSearch){
//            String sendra = table.identifyMostLikely(linkedSql,words);
//
//            if(sendra.equals(""))
//                counter++;
//
//            query.append(sendra);
//        }

        if(counter==3)
            query.append(" and false ");

        return query.toString();
    }

    public List<Scene> setupSearch(HibernateDAO linkedSql, String fullText) throws Exception {
//        String query = formatResearch(linkedSql,fullText);
        String query = "SELECT s.* FROM SCENE s";
        List<Scene> result = doSearch(linkedSql,query);
        for (Scene scene:result) {
            System.out.println(scene);
        }

        return result;
    }

    public List<Scene> doSearch(HibernateDAO dao,String query){
        dao.setTransaction(null);
        dao.setSession(null);

        List<Scene> results=null;

        try{
            dao.openConnection();
            Query dataQuery = dao.getSession().createNativeQuery(query,Scene.class);
            results=dataQuery.getResultList();
        }catch(Exception e ){
            e.printStackTrace();
            if (dao.getTransaction() != null) {
                dao.getTransaction().rollback();
            }
        }finally{
            dao.closeSession();
        }
        return results;

    }
}
