package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.Service.FilmService;
import com.antonio.spring_mvc.model.Film;
import com.antonio.spring_mvc.model.Filmctg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmController {
    @Autowired
    HibernateDAO dao;

    public void setDao(HibernateDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/createFilm")
    public String createFilm(Model model){
        model.addAttribute("movieCategs",dao.findAll(new Filmctg()));
        return "Pages/Film/CreateMovie";
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("allMovies",dao.findAll(new Film()));
        return "Pages/Film/ListFilm";
    }

    @GetMapping("/test")
    public String test(){
        return "Pages/card";
    }

    @PostMapping
    public String doCreateMovie(Model model,@RequestParam String title, @RequestParam String description, @RequestParam int filmctg_id, @RequestParam double fond, @RequestParam Date production_date){
        try {
            new FilmService().saveFilm(dao,title, description, filmctg_id, fond,production_date);
        } catch (Exception e) {
                model.addAttribute("error",e.getMessage());
        }
        
        return createFilm(model);
    }
}
