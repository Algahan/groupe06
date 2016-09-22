package com.adaming.myapp.service;

import java.util.Date;
import java.util.List;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Reservation;
import com.adaming.myapp.bo.Voiture;

public interface IAgenceService extends IGenericService<Agence> {
	
	double getChiffreAffaire(long pAgenceId, int pAnnee);
	
	List<Voiture> getVoituresDisponibles(long pAgenceId, Date dateDebut, Date dateFin);
	
	List<Reservation> getListeReservations(long pAgenceId);
	
	List<Voiture> getListeVoituresRetour(long pAgenceId, Date dateRetour);

}
