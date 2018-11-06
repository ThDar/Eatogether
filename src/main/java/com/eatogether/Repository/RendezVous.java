package com.eatogether.Repository;

import java.util.Date;

public class RendezVous {

    private int id;
    private User idLiker;
    private User idTargetLiker;
    private String idRestraunt;
    private Date dateRdv ;
    private String note;
    private boolean accepted; // 0 default value or not accepted else 1
    private boolean acceptUpdate; // default value or update not accepted , else 1
    private boolean annule; // 0 default value or not cancelled yet 1 if it s cancelled

    public User getIdLiker() {
        return idLiker;
    }

    public void setIdLiker(User idLiker) {
        this.idLiker = idLiker;
    }



    public User getIdTargetLiker() {
        return idTargetLiker;
    }

    public void setIdTargetLiker(User idTargetLiker) {
        this.idTargetLiker = idTargetLiker;
    }



    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Date getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public String getIdRestraunt() {
        return idRestraunt;
    }

    public void setIdRestraunt(String idRestraunt) {
        this.idRestraunt = idRestraunt;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isAcceptUpdate() {
        return acceptUpdate;
    }

    public void setAcceptUpdate(boolean acceptUpdate) {
        this.acceptUpdate = acceptUpdate;
    }

    public boolean isAnnule() {
        return annule;
    }

    public void setAnnule(boolean annule) {
        this.annule = annule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RendezVous(User idLiker, User idTargetLiker, String idRestraunt, Date dateRdv, String note, boolean accepted, boolean acceptUpdate, boolean annule) {
        this.idLiker = idLiker;
        this.idTargetLiker = idTargetLiker;
        this.idRestraunt = idRestraunt;
        this.dateRdv = dateRdv;
        this.note = note;
        this.accepted = accepted;
        this.acceptUpdate = acceptUpdate;
        this.annule = annule;
    }

    public RendezVous() {
    }
}