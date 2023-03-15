package com.antonio.spring_mvc.Service;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.Film;
import com.antonio.spring_mvc.model.Plateau;
import com.antonio.spring_mvc.model.Scene;
import com.antonio.spring_mvc.model.Scenestatus;
import org.springframework.web.bind.annotation.RequestParam;

public class Scene_Service {

    public void newScene(int film_id, int plateau_id, String description, HibernateDAO dao){
        Plateau plateau=new Plateau();
        plateau.setId(plateau_id);

        Film film=new Film();
        film.setId(film_id);

        film=(Film)dao.find(film,true,0,0).get(0);
        plateau=(Plateau)dao.find(plateau,true,0,0).get(0);

        Scene scene=new Scene(film,plateau,description);

        dao.save(scene);

    }
}
