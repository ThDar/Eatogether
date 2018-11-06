package com.eatogether.Repository;

public class Categories {


    private int idCategorie;
    private String nameCategorie;
    private String descriptionCategorie;

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNameCategorie() {
        return nameCategorie;
    }

    public void setNameCategorie(String nameCategorie) {
        this.nameCategorie = nameCategorie;
    }

    public String getDescriptionCategorie() {
        return descriptionCategorie;
    }

    public void setDescriptionCategorie(String descriptionCategorie) {
        this.descriptionCategorie = descriptionCategorie;
    }

    public Categories(int idCategorie, String nameCategorie, String descriptionCategorie) {
        this.idCategorie = idCategorie;
        this.nameCategorie = nameCategorie;
        this.descriptionCategorie = descriptionCategorie;
    }

    public Categories() {
    }
}
