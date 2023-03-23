package com.antonio.spring_mvc.Service;

import com.antonio.spring_mvc.DAO.HibernateDAO;
import com.antonio.spring_mvc.model.Film;
import com.antonio.spring_mvc.model.Filmctg;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

public class FilmService {
    public void saveFilm(HibernateDAO dao, String title, String description, int filmctg_id, double fond, Date production_date) throws Exception {
        if(production_date==null)
            throw  new Exception("date de production non specifier");

        if(title.equals("") || description.equals(""))
            throw  new Exception("titre ou description non specifier");

        Film f = new Film();
        f.setTitle(title);
        f.setDescription(description);
        f.setFond(fond);
        f.setProduction_date(production_date);

        Filmctg filmctg = new Filmctg();
        filmctg.setId(filmctg_id);
        filmctg = (Filmctg) dao.findById(filmctg);

        f.setFilmctg_id(filmctg);

        dao.save(f);
    }
}
