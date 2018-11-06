package com.eatogether.Consumer.Transformation.Implementation;


import com.eatogether.Consumer.Transformation.ICatTransformation;
import com.eatogether.Repository.RepositoryBean.CategoriesBean;
import com.eatogether.Repository.Categories;

import java.util.ArrayList;

public class TransformationCategories implements ICatTransformation {


    @Override
    public ArrayList<Categories> FromCategoriesbeansToCategories(ArrayList<CategoriesBean> liste) {
        ArrayList<Categories> listecategories=new ArrayList<Categories>();
        for (CategoriesBean cb : liste)
        {Categories categories= new Categories();

            categories.setNameCategorie(cb.getNomCategorie());
            categories.setDescriptionCategorie(cb.getDescriptionCategorie());
            listecategories.add(categories);
        }

        return listecategories;
    }

    @Override
    public ArrayList<CategoriesBean> FromCategoriesToCategoriesBeans(ArrayList<Categories> liste) {
        ArrayList<CategoriesBean> listecategoriesbeans=new ArrayList<CategoriesBean>();
        for (Categories c : liste)
        {CategoriesBean categories= new CategoriesBean();

            categories.setNomCategorie(c.getNameCategorie());
            categories.setDescriptionCategorie(c.getDescriptionCategorie());
            listecategoriesbeans.add(categories);
        }

        return listecategoriesbeans;
    }
}
