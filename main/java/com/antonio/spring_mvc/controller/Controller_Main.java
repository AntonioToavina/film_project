package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Main {
    @Autowired
    HibernateDAO dao;
    public void setDao(HibernateDAO dao) {}

    @GetMapping("/index")
    public String logout(){
        return "index";
    }
}
