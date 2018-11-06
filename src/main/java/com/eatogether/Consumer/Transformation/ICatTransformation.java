package com.eatogether.Consumer.Transformation;

import com.eatogether.Repository.Categories;
import  com.eatogether.Repository.RepositoryBean.*;

import java.util.ArrayList;

public interface ICatTransformation {
    public ArrayList<Categories> FromCategoriesbeansToCategories (ArrayList<CategoriesBean> liste);
    public ArrayList<CategoriesBean> FromCategoriesToCategoriesBeans(ArrayList<Categories> liste);

}
