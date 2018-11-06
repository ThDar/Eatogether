package com.eatogether.Consumer;
import  com.eatogether.Repository.RepositoryBean.*;

import java.util.ArrayList;

public interface ICategories {

    public void persistListCateories(ArrayList<CategoriesBean> liste );
    public ArrayList<CategoriesBean> getListCateories();
}
