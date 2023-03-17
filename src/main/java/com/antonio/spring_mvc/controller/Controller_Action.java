package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.*;
import com.antonio.spring_mvc.model.Act;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;

@Controller
public class Controller_Action {
    @Autowired
    HibernateDAO dao;

    @GetMapping("/action")
    public String to_createAction(Model model){
        model.addAttribute("acttype",dao.findAll(new Acttype()));
        model.addAttribute("scenes",dao.findAll(new Scene()));
        model.addAttribute("acteurs",dao.findAll(new Acteur()));
        model.addAttribute("emotions",dao.findAll(new Emotion()));

        return "Pages/creation-action";
    }

    @PostMapping("/action")
    public String to_insertAction(@RequestParam() int acttype,@RequestParam() int scene,@RequestParam() int acteur,@RequestParam() int emotion,@RequestParam(defaultValue = "00:00") String debut,@RequestParam() String fin,@RequestParam() int duree,@RequestParam(defaultValue = "OO:OO") String action){

        Acttype type = new Acttype();
        type.setId(acttype);
        Scene s = new Scene();
        s.setId(scene);
        Acteur actor = new Acteur();
        actor.setId(acteur);
        Emotion em = new Emotion();
        em.setId(emotion);

        Act act;
        act = new Act();
        act.setFirsthour(java.sql.Time.valueOf(debut+":00"));
        act.setLasthour(java.sql.Time.valueOf(fin+":00"));
        act.setDuration(duree);
        act.setAction(action);

        act.setEmotion_id((Emotion)dao.findById(em));
        act.setActeur_id((Acteur)dao.findById(actor));
        act.setScene_id((Scene)dao.findById(s));
        act.setActtype_id((Acttype) dao.findById(type));

        dao.save(act);
        return "vide";
    }

    public HibernateDAO getDao() {
        return dao;
    }

    public void setDao(HibernateDAO dao) {
        this.dao = dao;
    }
}
