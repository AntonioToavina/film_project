package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.Service.Scene_Service;
import com.antonio.spring_mvc.model.Acteur;
import com.antonio.spring_mvc.model.Film;
import com.antonio.spring_mvc.model.Plateau;
import com.antonio.spring_mvc.model.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("acteurs",dao.findAll(new Acteur()));
        return "Pages/Listes_Acteurs";
    }

}
