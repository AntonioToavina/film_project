package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.Service.Research;
import com.antonio.spring_mvc.Service.Scene_Service;
import com.antonio.spring_mvc.model.Auteur;
import com.antonio.spring_mvc.model.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/research")
    public String doSearch(Model model,String keyword){
        model.addAttribute("maxStatusId",new Scene_Service().findMaxId(dao));
        model.addAttribute("allAuteurs",dao.findAll(new Auteur()));
        try {
            model.addAttribute("allMatchScenes",new Research().setupSearch(dao,keyword));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Pages/ListScenesModification";
    }

    @PostMapping("/changeAuthor/{idFilm}/{idScene}")
    public String changeAuthor(@PathVariable int idFilm,@PathVariable int idScene, @RequestParam int idAuthor){
        new Scene_Service().changeAuthor(dao,idAuthor,idScene);
        return "redirect: /scenes/"+idFilm;
    }
}
