package com.eatogether.Consumer.Implementation;
import com.eatogether.Consumer.IUsers;
import com.eatogether.Repository.RepositoryBean.RendezVousBean;
import com.eatogether.Repository.RepositoryBean.UtilisateurBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class UsersImplementation implements IUsers {

    EntityManagerFactory EntityManagerfactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

    EntityManager entityManager = EntityManagerfactory.createEntityManager();

    private String USER_DETAILS="Select u from UtilisateurBean u where u.adressemail =:newmail";
    private String USER_REGISTRED="Select u from UtilisateurBean u where u.adressemail =:newmail and u.motpasse =:newpassword";
    private String USER_DETAILS_BY_ID="Select u from UtilisateurBean u where u.id =: id";
    private String USER_UPDATE="update UtilisateurBean u set u.nom =: newnom ,u.pseudo=: newpseudo , u.prenom=: newprenom, u.datedenaissance =: newdateofbirth , u.sexe =: newsexe where u.adressemail =: adressmail ";              
    private String USER_PASS="update UtilisateurBean u set u.motpasse =: password where u.adressemail =: adressmail ";
    @Override
    public void persistuser(UtilisateurBean user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUser(UtilisateurBean user) {

        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();

    }

    @Override
    public UtilisateurBean getUserDetails(String mail) {
        Query details =entityManager.createQuery(USER_DETAILS);
        details.setParameter("newmail",mail);

        return (UtilisateurBean) details.getSingleResult();
    }
    
    
    
    @Override
    public boolean getUserexist(String mail,String password) {
    	boolean test = false ;
        Query details =entityManager.createQuery(USER_REGISTRED);
        details.setParameter("newmail",mail);
        details.setParameter("newpassword",password);
        
       if ((UtilisateurBean) details.getSingleResult()!=null) {
    	   test = true ;
       }
       return test ; 
    }
    
    @Override
    public boolean getUserexistemail(String mail) {
    	boolean test = false ; 
        Query details =entityManager.createQuery(USER_DETAILS);
        details.setParameter("newmail",mail);
   
       if ((UtilisateurBean) details.getSingleResult()!=null) {
    	   test = true ; 
       }
       	return test ; 
    }

    @Override
    public void updateUserInformations(String pseudo , String prenom , String nom , String datenaissance , String sexe , String email) {
    	

        entityManager.getTransaction().begin();
    	 Query details =entityManager.createQuery(USER_UPDATE);
    	 details.setParameter("adressmail",email);
    	 details.setParameter("newnom",nom);
    	 details.setParameter("newprenom",prenom);
    	 details.setParameter("newpseudo",pseudo);
    	 details.setParameter("newdateofbirth",datenaissance);
    	 details.setParameter("newsexe",sexe);
    	 details.executeUpdate();
         entityManager.getTransaction().commit();
        
    }
    
    
    @Override
    public void updateUserpassword(String email , String password) {
    	

        entityManager.getTransaction().begin();
    	 Query details =entityManager.createQuery(USER_PASS);
    	 details.setParameter("adressmail",email);
    	 details.setParameter("password",password);
    	 details.executeUpdate();
         entityManager.getTransaction().commit();
        
    }

    @Override
    public UtilisateurBean getUserByID(int id) {
        Query details =entityManager.createQuery(USER_DETAILS_BY_ID);
        details.setParameter("id",id);

        return (UtilisateurBean) details.getSingleResult();
    }



}