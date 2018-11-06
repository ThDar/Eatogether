package com.eatogether.Consumer.Implementation;

import com.eatogether.Consumer.IRendezVous;
import com.eatogether.Consumer.IUsers;
import com.eatogether.Repository.RepositoryBean.RendezVousBean;
import com.eatogether.Repository.RepositoryBean.UtilisateurBean;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class RendezVousImplementation implements IRendezVous {

    EntityManagerFactory EntityManagerfactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    EntityManager entityManager = EntityManagerfactory.createEntityManager();
    IUsers iUsers = new UsersImplementation();
    SessionFactory sessionFactory ;


    String GET_LISTE_RDVS="select u from RendezVousBean u where u.idsource= :user or u.idvise=: user";
    String DELETE_RDV="Delete from RendezVousBean u where u.idRdv =:id";
    String UPDATE_RDV="Update  RendezVousBean u set u.daterdv =:Date where u.idRdv =:id";
    String ANNULER_RDV="Update  RendezVousBean u set u.idvise = null , u.accepted = false where u.idRdv =:id";
    String ADD_LIKER_RDV="Update  RendezVousBean u set u.idsource =:user where u.idRdv =:id" ;
    String ADD_TARGER_RDV="Update  RendezVousBean u set u.idvise =:user , u.accepted = true where u.idRdv =:id" ;
    String GET_RDV_BY_REST="select u from RendezVousBean u where u.idrestaurant =:idrest and u.idsource <>:user and u.accepted <> true and u.annule <> true" ;
    String GET_RDVS="select u from RendezVousBean u where u.idvise IS null and u.idsource <>:user and u.accepted <> true and u.annule <> true" ;
    String GET_FRIENDS="select u from RendezVousBean u where  u.idvise IS not null and u.idsource =:user or u.idvise=:user and u.accepted = true and u.annule <> true" ;




    @Override
    public RendezVousBean createRendezvous(RendezVousBean rdv) {
        entityManager.getTransaction().begin();
        entityManager.persist(rdv);

        entityManager.getTransaction().commit();
        return entityManager.find(RendezVousBean.class,rdv.getIdRdv());

    }

    @Override
    public ArrayList<RendezVousBean> ConsulterUserRdv(UtilisateurBean user) {
        entityManager.getTransaction().begin();

        Query details =entityManager.createQuery(GET_LISTE_RDVS);
        details.setParameter("user",user);
        entityManager.getTransaction().commit();

        return (ArrayList<RendezVousBean>) details.getResultList();
    }

    @Override
    public void deleteRdv(int idrdv) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(DELETE_RDV);
        query.setParameter("id",idrdv);
        query.executeUpdate();
        entityManager.getTransaction().commit();

    }
    
    @Override
    public void AnnulerRdv(int idrdv) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(ANNULER_RDV);
        query.setParameter("id",idrdv);
        query.executeUpdate();
        entityManager.getTransaction().commit();

    }

    @Override
    public RendezVousBean UpdateDateRdv(int rdv,Date daterdv) {

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(UPDATE_RDV);
        query.setParameter("Date",daterdv);
        query.setParameter("id",rdv);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return entityManager.find(RendezVousBean.class,rdv);


    }

    @Override
    public RendezVousBean InsertLikerToRDV(UtilisateurBean usercreate,int  rdv) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(ADD_LIKER_RDV);
        query.setParameter("user",usercreate);
        query.setParameter("id",rdv);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return entityManager.find(RendezVousBean.class,rdv);
    }

    @Override
    public RendezVousBean InsertTargetToLikerRDV(UtilisateurBean target, int id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(ADD_TARGER_RDV);
        query.setParameter("user",target);
        query.setParameter("id",id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return entityManager.find(RendezVousBean.class,id);

    }

    @Override
    public ArrayList<RendezVousBean> ConsulterRdvParRestaurant(String idRestaurant,UtilisateurBean user ) {
        entityManager.getTransaction().begin();

        Query details =entityManager.createQuery(GET_RDV_BY_REST);
        details.setParameter("idrest",idRestaurant);
        details.setParameter("user",user);
        entityManager.getTransaction().commit();

        return (ArrayList<RendezVousBean>) details.getResultList();
    }

    @Override
    public ArrayList<RendezVousBean> ConsulterTousRdvs(UtilisateurBean usercreate) {
        entityManager.getTransaction().begin();

        Query details =entityManager.createQuery(GET_RDVS);
        details.setParameter("user",usercreate);
        entityManager.getTransaction().commit();

        return (ArrayList<RendezVousBean>) details.getResultList();
    }

    @Override
    public ArrayList<String> GetListOfFriends(UtilisateurBean usercreate) {
        ArrayList<String> friends = new ArrayList<String>();
        ArrayList<RendezVousBean> friendsBeans = new ArrayList<RendezVousBean>();

        entityManager.getTransaction().begin();

        Query details =entityManager.createQuery(GET_FRIENDS);
        details.setParameter("user",usercreate);
        entityManager.getTransaction().commit();
        friendsBeans = (ArrayList<RendezVousBean>) details.getResultList();
        
        for (RendezVousBean p : friendsBeans)
        {
            friends.add(iUsers.getUserByID(p.getIdvise().getId()).getAdressemail());
            friends.add(iUsers.getUserByID(p.getIdsource().getId()).getAdressemail());
        }
        List<String> listDistinct = friends.stream().distinct().collect(Collectors.toList());
        return (ArrayList<String>) listDistinct;
    }


}