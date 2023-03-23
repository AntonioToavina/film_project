package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.Act;
import com.antonio.spring_mvc.model.Film;
import com.antonio.spring_mvc.model.Plateau;
import com.antonio.spring_mvc.model.V_scenestatus;
import com.antonio.spring_mvc.planning.SuggestPlanning;
import com.antonio.spring_mvc.planning.TimingHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        SuggestPlanning planning=new SuggestPlanning();
        model.addAttribute("dates",planning.getAvailableDates(Date.valueOf("2023-03-21"),Date.valueOf("2023-03-30")));
        return "Pages/Planning/form";
    }
    @GetMapping("suggest_list")
    public String toList(@RequestParam Date debut, @RequestParam Date fin, @RequestParam(name = "selected-scenes") String scenes, @RequestParam(name = "display-scenes") String displayscenes, Model model){


        model.addAttribute("debut",debut);
        model.addAttribute("fin",fin);
        model.addAttribute("scenes",displayscenes);

        SuggestPlanning suggestPlanning = new SuggestPlanning();
        List<SuggestPlanning> planning = suggestPlanning.suggestPlanning(getDao(),debut,fin,scenes);
        model.addAttribute("planning",planning);
        return "Pages/Planning/list";
    }
}
