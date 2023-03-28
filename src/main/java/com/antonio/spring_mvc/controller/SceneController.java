package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.Service.Research;
import com.antonio.spring_mvc.model.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/scenes")
public class SceneController {
    @Autowired
    HibernateDAO dao;

    public void setDao(HibernateDAO dao) {
        this.dao = dao;
    }

    public HibernateDAO getDao() {
        return dao;
    }

    @GetMapping
    public String goToSearch(Model model){
        return "Pages/ResearchScene";
    }

    @PostMapping("/research")
    public void doSearch(Model model,String keyword){
        Research research = new Research();
        try {
            model.addAttribute("correspondingScene",research.setupSearch(dao,keyword));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
