package com.arm.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

import java.sql.Date;

@Entity
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCards;//id
    private int idOtv;//Ответсвенный
    private String numberCard;//Номер карточки
    private int numberLetter;//номер Письма
    private int system;//подсистема
    private Date dateCorrect;//дата корректировки карточки
    private Date dateCreate;//дата создания
    private Date sendLetter;//дата отправки письма
    private String links;//ссылка на письмо

    public int getIdCards() {
        return idCards;
    }

    public void setIdCards(int idCards) {
        this.idCards = idCards;
    }

    public int getIdOtv() {
        return idOtv;
    }

    public void setIdOtv(int idOtv) {
        this.idOtv = idOtv;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public int getNumberLetter() {
        return numberLetter;
    }

    public void setNumberLetter(int numberLetter) {
        this.numberLetter = numberLetter;
    }

    public int getSystem() {
        return system;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public Date getDateCorrect() {
        return dateCorrect;
    }

    public void setDateCorrect(Date dateCorrect) {
        this.dateCorrect = dateCorrect;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getSendLetter() {
        return sendLetter;
    }

    public void setSendLetter(Date sendLetter) {
        this.sendLetter = sendLetter;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }
public Cards(){}
    public Cards( int idOtv, String numberCard, int numberLetter, int system, Date dateCorrect, Date dateCreate, Date sendLetter, String links) {
        this.idOtv = idOtv;
        this.numberCard = numberCard;
        this.numberLetter = numberLetter;
        this.system = system;
        this.dateCorrect = dateCorrect;
        this.dateCreate = dateCreate;
        this.sendLetter = sendLetter;
        this.links = links;
    }
    public String ToString(){

        return String.format(
                "Cards[idCards=%d, idOtv=%d, links='%s',numberCard='%s',numberLetter=%d,system=%d,dateCorrect=%tB,dateCreate=%tB,sendLetter=%tB]",
                idCards, idOtv,links,numberCard,numberLetter,system,dateCorrect,dateCreate,sendLetter);
    }
}
