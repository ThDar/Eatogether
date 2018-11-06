package com.eatogether.Repository;

import java.util.Date;

public class User {


    private String nom;
    private String prenom;
    private String pseudo;
    private String mail;
    private String motdepasse;
    private String datenaissance;
    private String sexe ;
    private String image ; 



    public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String date_naiss) {
        this.datenaissance = date_naiss;
    }
}
