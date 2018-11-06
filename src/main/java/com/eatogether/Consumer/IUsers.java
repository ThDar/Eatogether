package com.eatogether.Consumer;

import com.eatogether.Repository.RepositoryBean.UtilisateurBean;

public interface IUsers {

    public void persistuser(UtilisateurBean user);
    public void deleteUser(UtilisateurBean user);
    public UtilisateurBean getUserDetails(String mail);
    public UtilisateurBean getUserByID(int id);
    boolean getUserexist(String mail,String password);
    boolean getUserexistemail(String mail);
	public void updateUserInformations(String pseudo, String prenom, String nom, String datenaissance, String sexe,String email);
	public void updateUserpassword(String email, String password);
}
