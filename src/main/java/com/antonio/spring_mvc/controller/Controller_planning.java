package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.*;
import com.antonio.spring_mvc.planning.SuggestPlanning;
import com.antonio.spring_mvc.planning.TimingHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("dates",planning.getAvailableDates(Date.valueOf("2023-03-21"),Date.valueOf("2023-03-30"),getDao()));
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
    @GetMapping
    public String show_planning(@RequestParam(required = false,defaultValue = "1000-01-01") Date debut, @RequestParam(required = false,defaultValue = "1000-01-01") Date fin, Model model){


        if (debut.equals(Date.valueOf("1000-01-01")))
            debut=null;
        if (fin.equals(Date.valueOf("1000-01-01")))
            fin=null;

        model.addAttribute("debut",debut);
        model.addAttribute("fin",fin);

        Planning p=new Planning();
        List<SuggestPlanning> planning = p.getPlanning(getDao(),debut,fin);
        List<Acteur> acteurs = (List) getDao().getActeurs(debut,fin);
        List<Plateau> plateaux = (List) getDao().getPlateaux(debut,fin);
        model.addAttribute("planning",planning);
        model.addAttribute("acteurs",acteurs);
        model.addAttribute("plateaux",plateaux);
        return "Pages/Planning/planning";
    }

    @PostMapping("/save")
    public String savePlanning(@RequestParam int[] act_id, @RequestParam Date[] date, @RequestParam Time[] debut){

//        System.out.println("act_id: "+act_id.length);
//        System.out.println("date: "+date.length);
//        System.out.println("debut: "+debut.length);

//        for (int i = 0; i < act_id.length; i++) {
//            int id = act_id[i];
//            Date dateValue = date[i];
//            Time debutValue = debut[i];
//            System.out.println("act_id: " + id + ", date: " + dateValue + ", debut: " + debutValue );
//        }

        SuggestPlanning service=new SuggestPlanning();

        service.savePlanning(getDao(),act_id, date, debut);


        return "redirect:/index";
    }
}
