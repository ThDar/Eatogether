package com.eatogether.Consumer.Transformation;

import com.eatogether.Repository.User;
import com.eatogether.Repository.RepositoryBean.UtilisateurBean;

public interface IUserTransformation {
    public UtilisateurBean fromUserToUserBean(User user);
    public User fromUserBeanToUser(UtilisateurBean user);
}
