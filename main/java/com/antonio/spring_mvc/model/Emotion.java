package com.antonio.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "emotion")
public class Emotion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pk_emotion_id_seq")
    @SequenceGenerator(name = "pk_emotion_id_seq",sequenceName = "emotion_id_seq",allocationSize = 1)
    private String id;

    String emotionname;

    public String getEmotionname() {
        return emotionname;
    }

    public void setEmotionname(String emotionname) {
        this.emotionname = emotionname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
