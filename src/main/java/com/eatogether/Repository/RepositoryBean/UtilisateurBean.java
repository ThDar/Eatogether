package com.eatogether.Repository.RepositoryBean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UtilisateurBean {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator",strategy = "increment")
    private int id;

    @Column(name = "name")
    private String prenom;

    @Column(name = "secondname")
    private String nom;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "password")
    private String motpasse;

    @Column(name = "mail")
    private String adressemail;

    @Column(name = "dateofbirth")
    private String datedenaissance;
    
    @Column(name = "image")
    private String image ;
    
    @Column(name = "sexe")
    private String sexe ;

    @OneToMany(mappedBy = "idsource", fetch = FetchType.EAGER)
    private List<RendezVousBean> listesourcerdv ;

    @OneToMany(mappedBy = "idvise" , fetch = FetchType.EAGER)
    private List<RendezVousBean> listetarget ;


    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotpasse() {
        return motpasse;
    }

    public void setMotpasse(String motpasse) {
        this.motpasse = motpasse;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    public String getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(String string) {
        this.datedenaissance = string;
    }

    public UtilisateurBean(String prenom, String nom, String pseudo, String motpasse, String adressemail, String datedenaissance,String sexe , String image) {
        this.prenom = prenom;
        this.nom = nom;
        this.pseudo = pseudo;
        this.motpasse = motpasse;
        this.adressemail = adressemail;
        this.datedenaissance = datedenaissance;
        this.sexe = sexe ; 
        this.image = image ; 
    }

    public UtilisateurBean(String nom) {
        this.nom = nom;
    }

    public UtilisateurBean() {

    }

    public List<RendezVousBean> getListesourcerdv() {
        return listesourcerdv;
    }

    public void setListesourcerdv(List<RendezVousBean> listesourcerdv) {
        this.listesourcerdv = listesourcerdv;
    }

    public List<RendezVousBean> getListetarget() {
        return listetarget;
    }

    public void setListetarget(List<RendezVousBean> listetarget) {
        this.listetarget = listetarget;
    }
}
