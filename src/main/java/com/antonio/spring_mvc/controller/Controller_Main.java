package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.Service.Acteur_Service;
import com.antonio.spring_mvc.Service.Pagination;
import com.antonio.spring_mvc.Service.Scene_Service;
import com.antonio.spring_mvc.model.Acteur;
import com.antonio.spring_mvc.model.ActeurDispo;
import com.antonio.spring_mvc.model.Film;
import com.antonio.spring_mvc.model.Plateau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;

@Controller
public class Controller_Main {
    @Autowired
    HibernateDAO dao;
    public void setDao(HibernateDAO dao) {}

    @GetMapping("/index")
    public String to_createScene(Model model){
        model.addAttribute("films",dao.findAll(new Film()));
        model.addAttribute("plateaux",dao.findAll(new Plateau()));
        return "index";
    }


    @PostMapping("/scenes")
    public String createScene(@RequestParam int film_id, @RequestParam int plateau_id, @RequestParam String description){
        new Scene_Service().newScene(film_id,plateau_id,description,dao);
        return "redirect: /index";
    }

    @GetMapping("/to_listesActeurs")
    public String to_listesActeurs(Model model){
        Acteur acteur=new Acteur();
        Pagination.start=0;
        new Pagination().initPagination(dao,acteur);
        Pagination.limit=new Pagination().getLimit(dao);

        model.addAttribute("acteurs",dao.find(acteur,false,Pagination.start,Pagination.limit));
        model.addAttribute("currPage", Pagination.currPage);
        return "Pages/Listes_Acteurs";
    }

    @GetMapping("/to_listesActeurs/nextpage")
    public String nextPage_ListesActeurs(Model model,@RequestParam(defaultValue = "0") int increment){
        Acteur acteur=new Acteur();
        new Pagination().nextPage(increment,dao,acteur);
        model.addAttribute("currPage", Pagination.currPage);
        model.addAttribute("acteurs",dao.find(acteur,false,Pagination.start,Pagination.limit));
        return "Pages/Listes_Acteurs";
    }

    @GetMapping("/acteurs/{idacteur}/to_addIndisponibilite")
    public String to_addIndipsonibilite(@PathVariable int idacteur,Model model){
        ActeurDispo[] listDisponibility=new Acteur_Service().get_Indisponibility(idacteur,dao);
        model.addAttribute("dispos",listDisponibility);
        model.addAttribute("idacteur",idacteur);
        return "Pages/Disponibilty";
    }

    @PostMapping("/acteurs/{idacteur}/newIndisponibilite")
    public String newIndipsonibilite(@PathVariable int idacteur, String observation, Date notavailabledate, Model model){
        new Acteur_Service().newIndisponibility(idacteur,observation,notavailabledate,dao);
        return "redirect: /acteurs/"+idacteur+"/to_addIndisponibilite";
    }

}
