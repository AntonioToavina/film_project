package com.antonio.spring_mvc.Service;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.Acteur;
import com.antonio.spring_mvc.model.ActeurDispo;
import java.sql.Date;
import java.util.List;

public class Acteur_Service {

    public ActeurDispo[] get_Indisponibility(int idacteur, HibernateDAO dao){
        Acteur acteur=new Acteur();
        acteur.setId(idacteur);
        ActeurDispo acteurDispo=new ActeurDispo();
        acteurDispo.setActeur(acteur);

        List<Object> list=dao.find(acteurDispo,true,0,0);
        ActeurDispo[] listDisponibility=new ActeurDispo[0];
        if(list!=null){
            listDisponibility=new ActeurDispo[list.size()];
            for(int i=0;i<listDisponibility.length;i++){
                listDisponibility[i]=(ActeurDispo) list.get(i);
            }
        }

        return listDisponibility;
    }

    public void newIndisponibility(int idacteur, String observation, Date notavailabledate,HibernateDAO dao){
        ActeurDispo acteurDispo=new ActeurDispo();
        Acteur acteur=new Acteur();
        acteur.setId(idacteur);

        acteur=(Acteur) dao.find(acteur,true,0,0).get(0);
        acteurDispo.setActeur(acteur);
        acteurDispo.setNotavailabledate(notavailabledate);
        if(observation!=null)
            acteurDispo.setObservation(observation);

        dao.save(acteurDispo);
    }
}
