package com.eatogether.Consumer;

import com.eatogether.Repository.RepositoryBean.RendezVousBean;
import com.eatogether.Repository.RepositoryBean.UtilisateurBean;

import java.util.ArrayList;
import java.util.Date;

public interface IRendezVous {

    public RendezVousBean createRendezvous(RendezVousBean rdv);

    public ArrayList<RendezVousBean> ConsulterUserRdv (UtilisateurBean user);

    public void deleteRdv (int rdv);

    public RendezVousBean UpdateDateRdv(int rdv, Date daterdv);

    public RendezVousBean InsertLikerToRDV(UtilisateurBean usercreate,int  rdv);

    public RendezVousBean InsertTargetToLikerRDV(UtilisateurBean target, int id);

    public ArrayList<RendezVousBean> ConsulterRdvParRestaurant (String idRestaurant, UtilisateurBean user);
    public ArrayList<RendezVousBean> ConsulterTousRdvs (UtilisateurBean usercreate);
    public  ArrayList<String> GetListOfFriends(UtilisateurBean usercreate);

	public void AnnulerRdv(int idrdv);




}

