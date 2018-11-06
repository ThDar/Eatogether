package com.eatogether.Consumer.Implementation;

import com.eatogether.Consumer.ICategories;
import com.eatogether.Repository.RepositoryBean.CategoriesBean;
import com.eatogether.Repository.RepositoryBean.UtilisateurBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class CategoriesImplementation implements ICategories {
    EntityManagerFactory EntityManagerfactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    EntityManager entityManager = EntityManagerfactory.createEntityManager();
    private String GET_CATEGORIES="Select u from CategoriesBean u ";

    @Override
    public void persistListCateories(ArrayList<CategoriesBean> liste) {
        entityManager.getTransaction().begin();
        for(CategoriesBean categoriePersistence :liste)
        {
            entityManager.persist(categoriePersistence);
        }
        entityManager.getTransaction().commit();


    }

    @Override
    public ArrayList<CategoriesBean> getListCateories() {
        entityManager.getTransaction().begin();

        Query details =entityManager.createQuery(GET_CATEGORIES);

        entityManager.getTransaction().commit();

        return (ArrayList<CategoriesBean>) details.getResultList();
    }
}
