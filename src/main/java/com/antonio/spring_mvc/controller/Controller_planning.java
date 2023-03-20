package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.Film;
import com.antonio.spring_mvc.model.Plateau;
import com.antonio.spring_mvc.model.V_scenestatus;
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
        V_scenestatus scenestatus=new V_scenestatus();
        scenestatus.setValue(20);

        model.addAttribute("scenes",dao.find(scenestatus,true,0,0));
        return "Pages/Planning/form";
    }
    @GetMapping("suggest_list")
    public String toList(Model model){
        return "Pages/Planning/list";
    }
}
