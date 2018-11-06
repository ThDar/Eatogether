package com.eatogether.Repository.RepositoryBean;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RendezVous")
public class RendezVousBean {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator",strategy = "increment")
    private int idRdv;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idLiker", referencedColumnName = "id")
    private UtilisateurBean idsource;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTarget", referencedColumnName = "id")
    private UtilisateurBean idvise;

    @Column(name = "idRestaurant")
    private String idrestaurant;

    @Column(name = "dateTodate")
    private Date daterdv;

    @Column(name = "note")
    private String note;

    @Column(name = "isAccepted")
    private boolean accepted; // 0 default value or not accepted else 1

    @Column(name = "updateIsAccepted")
    private boolean acceptUpdate; // default value or update not accepted 0 , else 1

    @Column(name = "cancelledDate")
    private boolean annule; // 0 default value or not cancelled yet 1 if it s cancelled




    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
    }

    public UtilisateurBean getIdsource() {
        return idsource;
    }

    public void setIdsource(UtilisateurBean idsource) {
        this.idsource = idsource;
    }

    public UtilisateurBean getIdvise() {
        return idvise;
    }

    public void setIdvise(UtilisateurBean idvise) {
        this.idvise = idvise;
    }

    public String getIdrestaurant() {
        return idrestaurant;
    }

    public void setIdrestaurant(String idrestaurant) {
        this.idrestaurant = idrestaurant;
    }

    public Date getDaterdv() {
        return daterdv;
    }

    public void setDaterdv(Date daterdv) {
        this.daterdv = daterdv;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public RendezVousBean(UtilisateurBean idsource, UtilisateurBean idvise, String idrestaurant, Date daterdv, String note, boolean accepted, boolean acceptUpdate, boolean annule) {
        this.idsource = idsource;
        this.idvise = idvise;
        this.idrestaurant = idrestaurant;
        this.daterdv = daterdv;
        this.note = note;
        this.accepted = accepted;
        this.acceptUpdate = acceptUpdate;
        this.annule = annule;
    }

    public RendezVousBean() {
    }
}
