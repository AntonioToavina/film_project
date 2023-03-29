package com.antonio.spring_mvc.model;

import com.antonio.spring_mvc.DAO.HibernateDAO;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="act")
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acttype_id")
    Acttype acttype_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scene_id")
    Scene scene_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acteur_id")
    Acteur acteur_id;

    Time firsthour;
    Time lasthour;
    int duration;
    String action;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emotion_id")
    Emotion emotion_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "act_id")
    Act act_id;

    public Act(int id, Acttype acttype_id, Scene scene_id, Acteur acteur_id, Time firsthour, Time lasthour, int duration, String action, Emotion emotion_id, Act act_id) {
        this.id = id;
        this.acttype_id = acttype_id;
        this.scene_id = scene_id;
        this.acteur_id = acteur_id;
        this.firsthour = firsthour;
        this.lasthour = lasthour;
        this.duration = duration;
        this.action = action;
        this.emotion_id = emotion_id;
        this.act_id = act_id;
    }

    @Override
    public String toString() {
        return "Act{" +
                "id=" + id +
                ", acttype_id=" + acttype_id +
                ", scene_id=" + scene_id +
                ", acteur_id=" + acteur_id +
                ", firsthour=" + firsthour +
                ", lasthour=" + lasthour +
                ", duration=" + duration +
                ", action='" + action + '\'' +
                ", emotion_id=" + emotion_id +
                ", act_id=" + act_id +
                '}';
    }

    public Act() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Acttype getActtype_id() {
        return acttype_id;
    }

    public void setActtype_id(Acttype acttype_id) {
        this.acttype_id = acttype_id;
    }

    public Scene getScene_id() {
        return scene_id;
    }

    public void setScene_id(Scene scene_id) {
        this.scene_id = scene_id;
    }

    public Acteur getActeur_id() {
        return acteur_id;
    }

    public void setActeur_id(Acteur acteur_id) {
        this.acteur_id = acteur_id;
    }

    public Time getFirsthour() {
        return firsthour;
    }

    public void setFirsthour(Time firsthour) {
        this.firsthour = firsthour;
    }

    public Time getLasthour() {
        return lasthour;
    }

    public void setLasthour(Time lasthour) {
        this.lasthour = lasthour;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Emotion getEmotion_id() {
        return emotion_id;
    }

    public void setEmotion_id(Emotion emotion_id) {
        this.emotion_id = emotion_id;
    }


    public List<Act> getActRelated(HibernateDAO dao){
        Act a=new Act();
//        a.setAct_id(this);
        a.setScene_id(getScene_id());
        List<Act> related = (List) dao.find(a,true,0,0);
        List<Act> result = new ArrayList<>();
        result.addAll(related);
        for (Act actR :
                related) {
            result.addAll(actR.getActRelated(dao));

        }
        return result;

    }

    public Act getAct_id() {
        return act_id;
    }

    public void setAct_id(Act act_id) {
        this.act_id = act_id;
    }


}
