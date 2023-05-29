package com.example.reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idScore")
    private Integer idScore;

    @Column(name = "Text")
    private String messageText;

    @Column(name = "stars")
    private Integer stars;

    @OneToOne
    @JsonIgnoreProperties({"score"})
    private Reservation reservation;

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
