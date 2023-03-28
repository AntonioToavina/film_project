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
        tableSearch = new TableSearch[4];
        tableSearch[0] = new TableSearch("film","title","ilike");
        tableSearch[0].setEncapsulate(true);

        tableSearch[1] = new TableSearch("plateau","location","ilike");
        tableSearch[1].setEncapsulate(true);

        tableSearch[2] = new TableSearch("scene","description","ilike");
        tableSearch[2].setEncapsulate(true);

        tableSearch[3] = new TableSearch("auteur","nom","ilike");
        tableSearch[3].setEncapsulate(true);
    }


    public String formatResearch(HibernateDAO linkedSql,String fullText) throws Exception {
//        Explode the text in word
        String[] words = fullText.split("-");
        Research research = new Research();
        int counter = 0;

        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM v_scene_details WHERE true ");
//
        for(TableSearch table : research.tableSearch){
            String sendra = table.identifyMostLikely(linkedSql,words);
//
            if(sendra.equals(""))
                counter++;

            query.append(sendra);
        }

        if(counter==tableSearch.length)
            query.append(" and false ");

        return query.toString();
    }

    public List<Scene> setupSearch(HibernateDAO linkedSql, String fullText) throws Exception {
        String query = formatResearch(linkedSql,fullText);
        List<Scene> result = linkedSql.broadRequest(query,Scene.class);

        return result;
    }
}
