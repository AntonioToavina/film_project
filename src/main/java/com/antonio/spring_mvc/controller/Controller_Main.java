package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.Film;
import com.antonio.spring_mvc.model.Plateau;
import com.antonio.spring_mvc.model.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String createScene(@ModelAttribute Scene scene){
        scene.toString();

        return "index";
    }

}
