package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.Film;
import com.antonio.spring_mvc.model.Plateau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/planning")
public class Controller_planning {

    @Autowired
    HibernateDAO dao;

    public HibernateDAO getDao() {
        return dao;
    }

    public void setDao(HibernateDAO dao) {
        this.dao = dao;
    }


    @GetMapping("suggest_form")
    public String toForm(Model model){
        return "Pages/Planning/form";
    }
}
