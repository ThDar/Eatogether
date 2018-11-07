package com.eatogether.Consumer.test;

import com.eatogether.Consumer.IRendezVous;
import com.eatogether.Consumer.IUsers;
import com.eatogether.Consumer.Implementation.RendezVousImplementation;
import com.eatogether.Consumer.Implementation.UsersImplementation;
import com.eatogether.Consumer.Transformation.IRendezVousTransformation;
import com.eatogether.Consumer.Transformation.IUserTransformation;
import com.eatogether.Consumer.Transformation.Implementation.TransformationRdv;
import com.eatogether.Consumer.Transformation.Implementation.TransformationUser;
import com.eatogether.Repository.RendezVous;
import com.eatogether.Repository.RepositoryBean.RendezVousBean;
import com.eatogether.Repository.RepositoryBean.UtilisateurBean;
import com.eatogether.Repository.User;
import org.junit.jupiter.api.Test;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RendezVousImplementationTest {
    IRendezVous iRendezVous = new RendezVousImplementation();
    IRendezVousTransformation iRendezVousTransformation = new TransformationRdv();
    private IUsers iUsers = new UsersImplementation();
    IUserTransformation iUserTransformation = new TransformationUser();



    @Test
    public void TestGetRdvs()
    {
        ArrayList<RendezVous> listerdvs = new ArrayList<RendezVous>();

        Date d= new Date();
        d.setTime(10000);
        User user = new User();
        user.setNom("hello");
        user.setPrenom("darinetestj");
        user.setPseudo("coucu");
        user.setMail("theyri.darine01@gmail.com");
    //    user.setDatenaissance(d);
        user.setMotdepasse("1525425");
        UtilisateurBean utilisateurPersistance = iUserTransformation.fromUserToUserBean(user);
        iUsers.persistuser(utilisateurPersistance);
    //   listerdvs  = iRendezVousTransformation.fromListeRendezvousBeanToListeRendezvous(iRendezVous.ConsulterRdv(utilisateurPersistance));

        System.out.println(listerdvs.size());
    }


    /*@Test
    public void createRdv()
    {

        Date d= new Date();
        d.setTime(10000);
        User user = new User();
        user.setNom("hello");
        user.setPrenom("darinetestj");
        user.setPseudo("coucu");
        user.setMail("theyri.darine01@gmail.com");
        user.setDatenaissance(d);
        user.setMotdepasse("1525425");
        UtilisateurBean utilisateurPersistance = iUserTransformation.fromUserToUserBean(user);


        User user1 = new User();
        user1.setNom("nouhe");
        user1.setPrenom("nouhe");
        user1.setPseudo("coucu");
        user1.setMail("theyri.nouhe@gmail.com");
        user1.setDatenaissance(d);
        user1.setMotdepasse("1525425");
        UtilisateurBean utilisateurPersistance1 = iUserTransformation.fromUserToUserBean(user1);
        iUsers.persistuser(utilisateurPersistance);
        iUsers.persistuser(utilisateurPersistance1);

        RendezVous rdv1 = new RendezVous();
        Date d1= new Date();
        d1.setTime(50000);
        rdv1.setIdRestraunt(5);
        rdv1.setDateRdv(d1);
        rdv1.setNote("tresbon");
        rdv1.setIdLiker(user);
        rdv1.setIdTargetLiker(user1);
        iRendezVous.createRendezvous(iRendezVousTransformation.fromRendezvousToRendezvousBean(rdv1));




    }*/

    @Test
    public void createRdvWithouttarget()
    {
        User user = new User();
        user = iUserTransformation.fromUserBeanToUser(iUsers.getUserDetails("theyri.darine01@gmail.com"));
        RendezVous rdv1 = new RendezVous();
//        rdv1.setIdRestraunt(5);
        rdv1.setDateRdv(java.util.Calendar.getInstance().getTime());
        rdv1.setNote("tresbon");
        RendezVousBean liste =iRendezVous.createRendezvous(iRendezVousTransformation.fromRendezvousToRendezvousBean(rdv1));
        RendezVousBean liste1= iRendezVous.InsertLikerToRDV(iUsers.getUserDetails("theyri.darine01@gmail.com"),liste.getIdRdv());

    }

    @Test
    public void getListOf()
    {


  //      List<RendezVousBean> liste =iRendezVous.ConsulterRdv(iUsers.getUserDetails("theyri.darine01@gmail.com"));
   //     System.out.println(liste.size());

    }
}
