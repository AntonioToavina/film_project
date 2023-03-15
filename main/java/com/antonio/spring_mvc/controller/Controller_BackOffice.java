package com.antonio.spring_mvc.controller;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.Service.Pagination;
import com.antonio.spring_mvc.model.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;


public class Controller_BackOffice {

    /*
    @Autowired
    HibernateDAO dao;

    @GetMapping("/pagelog")
    public String pageLog(){
        return "Auteur/Login";
    }

    @GetMapping("/pagelogAdmin")
    public String pageLogAdmin(){
        return "Admin/LoginAdmin";
    }

    public void manageListesPub(Publicite pub,HttpServletRequest request){
        HttpSession session=request.getSession();
        Utilisateur user= (Utilisateur)session.getAttribute("user");

        if(user.getUsertype().getIdtypeuser()==2)
            pub.setUtilisateur(user);
    }

    @GetMapping("/admin/home")
    public String toHome(Model model,HttpServletRequest request){
        Publicite pub=new Publicite();
        manageListesPub(pub,request);

        PaginationAdmin.start=0;
        new PaginationAdmin().initPagination(dao,pub);
        PaginationAdmin.limit=new Pagination().getLimit(dao);

        List<Object> listPub=dao.find(pub,false,PaginationAdmin.start,PaginationAdmin.limit);
        Publicite[] publicites=new Publicite[listPub.size()];

        List<Object> listEtat=dao.findAll(new Etat());
        Etat[] etats=new Etat[listEtat.size()];

        Utilisateur user=new Utilisateur();
        UserType userType=new UserType();
        userType.setIdtypeuser(2);
        user.setUsertype(userType);

        List<Object> listAuteur=dao.find(user,false,PaginationAdmin.start,PaginationAdmin.limit);
        Utilisateur[] auteurs=new Utilisateur[listAuteur.size()];

        for(int i=0;i<listEtat.size();i++)
            etats[i]=(Etat) listEtat.get(i);

        for(int i=0;i<publicites.length;i++)
            publicites[i]=(Publicite) listPub.get(i);

        for(int i=0;i<auteurs.length;i++)
            auteurs[i]=(Utilisateur)listAuteur.get(i);

        model.addAttribute("publicites",publicites);
        model.addAttribute("etats",etats);
        model.addAttribute("currPage", PaginationAdmin.currPage);
        model.addAttribute("auteurs",auteurs);
        HttpSession session=request.getSession();
        model.addAttribute("user",(Utilisateur)session.getAttribute("user"));

        return "Admin/Publcites_Creer";
    }

    @PostMapping("/user/login")
    public String login(@ModelAttribute Utilisateur user,Model model,HttpServletRequest request){
        PaginationAdmin.limit=50;
        PaginationAdmin.start=0;
        List<Object> list=dao.find(user,true,PaginationAdmin.start,PaginationAdmin.limit);
        if(list.size()==0)
            return "redirect: /index";

        user=(Utilisateur) list.get(0);
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        return "redirect: /admin/home";
    }

    @GetMapping("/admin/pub/next")
    public String nextPage(@RequestParam(defaultValue = "0") int increment,Model model,HttpServletRequest request){
        Publicite publicite=new Publicite();
        HttpSession session=request.getSession();
        Utilisateur user=(Utilisateur)session.getAttribute("user");
        M_Pagination pagination=null;

        if(user.getUsertype().getIdtypeuser()==2){
            pagination= new PaginationAuteur();
            pagination.nextPage(increment,dao);
        }
        else{
            new PaginationAdmin().nextPage(increment,dao);
        }

        List<Object> list=dao.find(publicite,false,PaginationAdmin.start,PaginationAdmin.limit);
        Publicite[] publicites=new Publicite[list.size()];

        List<Object> listEtat=dao.findAll(new Etat());
        Etat[] etats=new Etat[listEtat.size()];
        for(int i=0;i<listEtat.size();i++)
            etats[i]=(Etat) listEtat.get(i);

        for(int i=0;i<publicites.length;i++)
            publicites[i]=(Publicite) list.get(i);

        List<Object> listAuteur=dao.findAll(new Utilisateur());
        Utilisateur[] auteurs=new Utilisateur[listAuteur.size()];

        for(int i=0;i<auteurs.length;i++)
            auteurs[i]=(Utilisateur)listAuteur.get(i);

        model.addAttribute("publicites",publicites);
        model.addAttribute("etats",etats);
        model.addAttribute("currPage", PaginationAdmin.currPage);
        model.addAttribute("auteurs",auteurs);
        model.addAttribute("user",(Utilisateur)session.getAttribute("user"));
        return "Admin/Publcites_Creer";
    }

    @PostMapping("/publicites/publish/matched")
    public String publicites_Matched_Publish(HttpServletRequest request,Model model,@RequestParam(defaultValue = "") String auteur,@RequestParam(defaultValue = "") String titre,@RequestParam(defaultValue = "0") int idetat ){
        Publicite publicite=new Publicite();
        if(!auteur.equals("")){
            Utilisateur auteur1=new Utilisateur();
            auteur1.setIduser(Integer.parseInt(auteur));
            publicite.setUtilisateur(auteur1);
        }

        if(!titre.equals(""))
            publicite.setTitre(titre);

        Etat etat=new Etat();
        if(idetat!=0){
            etat.setIdetat(idetat);
            publicite.setEtat(etat);
        }

        manageListesPub(publicite,request);
        PaginationAdmin.limit=30;
        PaginationAdmin.start=0;
        List<Object> list=dao.find(publicite,false,PaginationAdmin.start,PaginationAdmin.limit);
        Publicite[] publicites=new Publicite[list.size()];

        for(int i=0;i<publicites.length;i++)
            publicites[i]=(Publicite) list.get(i);

        List<Object> listEtat=dao.findAll(new Etat());
        Etat[] etats=new Etat[listEtat.size()];
        for(int i=0;i<listEtat.size();i++)
            etats[i]=(Etat) listEtat.get(i);

        Utilisateur user=new Utilisateur();
        UserType userType=new UserType();
        userType.setIdtypeuser(2);
        user.setUsertype(userType);
        List<Object> listAuteur=dao.find(user,false,PaginationAdmin.start,PaginationAdmin.limit);
        Utilisateur[] auteurs=new Utilisateur[listAuteur.size()];

        for(int i=0;i<auteurs.length;i++)
            auteurs[i]=(Utilisateur)listAuteur.get(i);
        HttpSession session=request.getSession();

        model.addAttribute("publicites",publicites);
        model.addAttribute("etats",etats);
        model.addAttribute("currPage", PaginationAdmin.currPage);
        model.addAttribute("auteurs",auteurs);
        model.addAttribute("user",(Utilisateur)session.getAttribute("user"));

        return "Admin/Publcites_Creer";
    }

    @GetMapping("/addPublish_date")
    public String to_AddPublishDate(Model model,@RequestParam int idpub){
        model.addAttribute("idpub",idpub);
        return "Admin/AddPublishDate";
    }

    @PostMapping("/savePublishDate")
    public String add_PublishDate(Model model,@RequestParam int idpub,@RequestParam String datepublication){
        String[] date=datepublication.split("T");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(date[0]+" "+date[1]));
        Timestamp t =Timestamp.valueOf(localDateTime);
        Publicite pub=new Publicite();
        pub.setIdpub(idpub);

        PaginationAdmin.start=0;
        List<Object> list=dao.find(pub,false,PaginationAdmin.start,PaginationAdmin.limit);
        pub=(Publicite)list.get(0);

        pub.setDatepublication(t);
        dao.update(pub);

        return "redirect: /admin/home";
    }

    @GetMapping("/publicites/publish")
    public String publish_Publicites(@RequestParam int id, Model model){
        Publicite publicite=new Publicite();
        publicite.setIdpub(id);
        PaginationAdmin.limit=2;
        PaginationAdmin.start=0;
        List<Object> list=dao.find(publicite,false,PaginationAdmin.start,PaginationAdmin.limit);
        publicite=(Publicite)list.get(0);

        Etat etat=new Etat();
        etat.setIdetat(2);
        publicite.setEtat(etat);
        dao.update(publicite);

        PaginationAdmin.limit=50;
        PaginationAdmin.start=0;
        return "redirect: /admin/home";
    }

    @GetMapping("/admin/publicites")
    public String Publicite_Creer(Model model){
        Publicite pub=new Publicite();
        Etat etat=new Etat();
        etat.setIdetat(1);
        pub.setEtat(etat);
        PaginationAdmin.limit=50;
        PaginationAdmin.start=0;

        return "redirect: /admin/home";
    }

    @GetMapping("/createPublicite")
    public String createPublicite(Model model){
        model.addAttribute("categorie",dao.findAll(new Categorie()));
        return "Auteur/NewPublicite";
    }

    @GetMapping("/publicicte/{idpub}/tomodif")
    public String toModif(Model model,@PathVariable int idpub,HttpServletRequest request){
        Publicite pub=new Publicite();
        pub.setIdpub(idpub);
        pub=(Publicite) dao.findById(pub);

        model.addAttribute("pub",pub);
        model.addAttribute("categorie",dao.findAll(new Categorie()));
        model.addAttribute("etat",dao.findAll(new Etat()));
        model.addAttribute("idpub",idpub);
        HttpSession session=request.getSession();
        model.addAttribute("user",(Utilisateur)session.getAttribute("user"));
        return "Admin/ModifPubAdmin";
    }


    @PostMapping("/publicite/{idpub}/modif")
    public String modifPub(HttpServletRequest request,@PathVariable int idpub){
        Publicite publicite=new Publicite();
        publicite.setIdpub(idpub);
        publicite=(Publicite)dao.findById(publicite);

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    String value=new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
                    switch (item.getFieldName()){
                        case "lieu":
                            if(!value.equals(""))
                                publicite.setLieu(value);
                            break;

                        case "titre":
                            publicite.setTitre(value);
                            break;

                        case "resumer":
                            publicite.setResumer(value);
                            break;

                        case "date1":
                            publicite.setDate1(Date.valueOf(value));
                            break;

                        case "date2":
                            publicite.setDate2(Date.valueOf(value));
                            break;

                        case "datepublication":
                            if(!value.equals("")){
                                String[] date=value.split("T");
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                                LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(date[0]+" "+date[1]));
                                Timestamp t =Timestamp.valueOf(localDateTime);
                                publicite.setDatepublication(t);
                            }
                            break;

                        case "idetat":
                            if(!value.equals("")){
                                Etat etat=new Etat();
                                etat.setIdetat(Integer.parseInt(value));
                                publicite.setEtat(etat);
                            }
                            break;

                        case "idcategorie":
                            Categorie cat=new Categorie();
                            cat.setIdcategorie(Integer.parseInt(value));
                            publicite.setCategorie(cat);
                            break;
                    }

                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        if(!name.equals("")){
                            File file=new File("/home/antonio/ITU/Naina/SpringMVC/Project/Project1/src/main/webapp/resources/theme/Images" + File.separator + name);
                            if(!file.exists())
                                item.write(file);
                            byte[] filecontent= FileUtils.readFileToByteArray(file);
                            publicite.setPhoto(Base64.getEncoder().encodeToString(filecontent));
                        }
                    }
                }

                HttpSession session=request.getSession();
                Utilisateur user= (Utilisateur)session.getAttribute("user");
                if(user.getUsertype().getIdtypeuser()==2){
                    Etat e=new Etat();
                    e.setIdetat(1);
                    publicite.setEtat(e);
                    publicite.setDatepublication(null);
                }

                dao.update(publicite);
            } catch (Exception ex) {
                System.out.println("File Upload Failed due to " + ex);
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            System.out.println("message No File found");
            request.setAttribute("message", "No File found");
        }

        return "redirect: /admin/home";
    }

    @PostMapping("publicite/choosepriority")
    public String choosePriority(HttpServletRequest request,Model model){
        String[] value=request.getParameterValues("pub");
        for(int i=0;i<value.length;i++){
            Publicite publicite=new Publicite();
            publicite.setIdpub(Integer.parseInt(value[i]));
            publicite=(Publicite) dao.findById(publicite);
            publicite.setPriority(1);
            dao.update(publicite);
        }

        return "redirect: /admin/home";
    }

    @PostMapping("/limitpage")
    public String addLimitPage(Model model,@RequestParam int nb){
        LimitPage limitPage=new LimitPage();
        limitPage.setIdlimit(1);
        limitPage.setValeur(nb);
        dao.update(limitPage);

        return "redirect: /admin/home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("user");

        return "redirect: /index";
    }

    public void setDao(HibernateDAO dao) {}
    */

}
