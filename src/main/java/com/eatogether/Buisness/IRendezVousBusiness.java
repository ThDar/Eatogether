package com.eatogether.Buisness;

import com.eatogether.Repository.RendezVous;
import com.eatogether.Repository.RepositoryBean.UtilisateurBean;
import com.eatogether.Repository.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IRendezVousBusiness {

    public RendezVous CreateRdvWithouTarget(String user, RendezVous rendezVous);
    public RendezVous AddTargetToRdv(String targer, int id);
    public RendezVous updateRDV(int rendezVous, Date date);
    public List<RendezVous> GetListRdvUser(String user);
    public List<RendezVous> GetListRdv_REST(String restaurant,String user);
    public List<RendezVous> GetListRdvS(String user);
    public ArrayList<String> GetListOfFriends(String user);

    public void DeleteRDV(int id);
    public void AnnulerRdv(int idrdv);

}
