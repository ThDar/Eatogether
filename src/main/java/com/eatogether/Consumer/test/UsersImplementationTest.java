package com.eatogether.Consumer.test;

import com.eatogether.Consumer.IUsers;
import com.eatogether.Consumer.Implementation.UsersImplementation;
import com.eatogether.Consumer.Transformation.IUserTransformation;
import com.eatogether.Consumer.Transformation.Implementation.TransformationUser;
import com.eatogether.Repository.User;
import com.eatogether.Repository.RepositoryBean.UtilisateurBean;
import org.junit.jupiter.api.Test;

import java.util.Date;

class UsersImplementationTest {
    private IUserTransformation iTransformation = new TransformationUser();
    private IUsers iUsers = new UsersImplementation();


    @Test
    public void TestSaveUser()
    {
        Date d= new Date();
        d.setTime(10000);
        User user = new User();
        user.setNom("hello");
        user.setPrenom("darinetestj");
        user.setPseudo("coucu");
        user.setMail("theyri.darine01@gmail.com");
 //       user.setDatenaissance(d);
        user.setMotdepasse("1525425");
        UtilisateurBean utilisateurPersistance = iTransformation.fromUserToUserBean(user);
        iUsers.persistuser(utilisateurPersistance);
    }
    @Test
    public void TestGetUser()
    {

        User user = iTransformation.fromUserBeanToUser(iUsers.getUserDetails("theyri.darine01@gmail.com"));
        System.out.println(user.getNom());
    }


}