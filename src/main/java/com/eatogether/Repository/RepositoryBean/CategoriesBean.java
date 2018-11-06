package com.eatogether.Repository.RepositoryBean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class CategoriesBean {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator",strategy = "increment")
    private int idcategorie;
    @Column(name = "nameCategory")
    private String nomCategorie;

    @Column(name = "descriptionCategory")
    private String descriptionCategorie;

    public CategoriesBean(int idcategorie, String nomCategorie, String descriptionCategorie) {
        this.idcategorie = idcategorie;
        this.nomCategorie = nomCategorie;
        this.descriptionCategorie = descriptionCategorie;
    }

    public CategoriesBean() {
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getDescriptionCategorie() {
        return descriptionCategorie;
    }

    public void setDescriptionCategorie(String descriptionCategorie) {
        this.descriptionCategorie = descriptionCategorie;
    }
}
