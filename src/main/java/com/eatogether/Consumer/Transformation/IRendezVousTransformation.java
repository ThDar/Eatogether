package com.eatogether.Consumer.Transformation;

import com.eatogether.Repository.RendezVous;
import com.eatogether.Repository.RepositoryBean.RendezVousBean;

import java.util.ArrayList;

public interface IRendezVousTransformation {

    public RendezVousBean fromRendezvousToRendezvousBean(RendezVous rdv);

    public RendezVous fromRendezvousBeanToRendezvous(RendezVousBean rdv);

    public ArrayList<RendezVous> fromListeRendezvousBeanToListeRendezvous(ArrayList<RendezVousBean> listerdv);
}
