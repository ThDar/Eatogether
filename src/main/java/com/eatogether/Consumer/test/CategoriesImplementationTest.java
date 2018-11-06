package com.eatogether.Consumer.test;

import com.eatogether.Consumer.ICategories;
import com.eatogether.Consumer.Implementation.CategoriesImplementation;
import com.eatogether.Consumer.Transformation.ICatTransformation;
import com.eatogether.Consumer.Transformation.Implementation.TransformationCategories;
import com.eatogether.Repository.Categories;
import com.eatogether.Repository.RepositoryBean.CategoriesBean;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CategoriesImplementationTest {

    ICatTransformation icatTransformation = new TransformationCategories();
    ICategories iCategories= new CategoriesImplementation();
    @Test
    public void testSavingCategories()
    {
        Categories cat = new Categories();
        cat.setNameCategorie("indien");
        cat.setDescriptionCategorie("nan,,..");
        ArrayList<Categories> list = new ArrayList<Categories>();
        list.add(cat);
        ArrayList<CategoriesBean> catlist = new ArrayList<CategoriesBean>();
        catlist=icatTransformation.FromCategoriesToCategoriesBeans(list);
        iCategories.persistListCateories(catlist);
    }


}