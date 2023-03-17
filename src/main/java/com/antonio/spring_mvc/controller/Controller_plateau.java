package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class Controller_plateau {
    @Autowired
    HibernateDAO dao;

    @GetMapping("/plateau")
    public String liste_plateau(Model model){
        model.addAttribute("plateaux",dao.findAll(new Plateau()));
        return "Pages/liste-plateau";
    }
    @PostMapping("/invalid-plateau")
    public String to_insertAction(@RequestParam() int plateau,@RequestParam() Date date, @RequestParam() String observation,Model model) {
        Plateau ref = new Plateau();
        ref.setId(plateau);

        PlateauDispo dispo = new PlateauDispo();
        dispo.setPlateau((Plateau) dao.findById(ref));
        dispo.setObservation(observation);
        dispo.setNotavailabledate(date);

        dao.save(dispo);
        model.addAttribute("message","configuration réussie");
        return "Pages/succes";
    }
    @GetMapping("/invalid-plateau")
    public String indisponibilite_plateau(Model model){
        model.addAttribute("plateaux",dao.findAll(new Plateau()));
        return "Pages/indisponibilite-plateau";
    }

    @GetMapping("/invalid-plateau-list/{idplateau}")
    @ResponseBody
    public String liste_indisponible_by_id(@PathVariable int idplateau){

        Plateau plateau = new Plateau();
        plateau.setId(idplateau);

        Plateau reference = (Plateau) dao.findById(plateau);

        PlateauDispo dispo = new PlateauDispo();
        dispo.setPlateau(reference);

        List list =  dao.find(dispo,true,0,0);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(list);
       return json;
    }
}
