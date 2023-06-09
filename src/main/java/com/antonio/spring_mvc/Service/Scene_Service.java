package com.antonio.spring_mvc.Service;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class Scene_Service {

    public void newScene(int film_id, int plateau_id, int auteur_id,String description, HibernateDAO dao){
        Plateau plateau=new Plateau();
        plateau.setId(plateau_id);

        Film film=new Film();
        film.setId(film_id);

        Auteur auteur=new Auteur();
        auteur.setId(auteur_id);

        film=(Film)dao.find(film,true,0,0).get(0);
        plateau=(Plateau)dao.find(plateau,true,0,0).get(0);
        auteur=(Auteur)dao.findById(auteur);

        Scene scene=new Scene(film,plateau,auteur,description);

        dao.save(scene);

    }

    public List<Object> findByFilmId(HibernateDAO hibernateDAO,int filmId){
        Film film = new Film();
        film.setId(filmId);

        Scene scene = new Scene();
        scene.setFilm(film);
        return hibernateDAO.find(scene,true,0,0);
    }

    public void upgradeSceneStatus(HibernateDAO dao,int idScene){
        Scene scene = new Scene();
        scene.setId(idScene);
        scene = (Scene) dao.findById(scene);

        Scenestatus scenestatus = (Scenestatus) dao.getHighClose(scene.getScenestatus().getValue());
        scenestatus = (Scenestatus) dao.findById(scenestatus);
        scene.setScenestatus(scenestatus);
        dao.update(scene);
    }

    public void changeAuthor(HibernateDAO dao,int idAuthor,int idScene){
        Scene scene = new Scene();
        scene.setId(idScene);
        scene = (Scene) dao.findById(scene);

        Auteur auteur = new Auteur();
        auteur.setId(idAuthor);
        auteur = (Auteur) dao.findById(auteur);
        scene.setAuteur(auteur);
        dao.update(scene);
    }

    public Object findMaxId(HibernateDAO dao) {
        try{
            dao.openConnection();
            String request = "select max(s.id) from Scenestatus s";
            Object o = dao.getSession().createQuery(request).list().get(0);
            dao.getSession().close();
            return o;
        }catch(Exception e){
            e.printStackTrace();
            if (dao.getTransaction() != null) {
                dao.getTransaction().rollback();
            }
        }finally {
            dao.closeSession();
        }

        return 0;
    }


}
