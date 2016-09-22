package com.adaming.myapp.dao;

import java.util.Date;
import java.util.List;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Facture;
import com.adaming.myapp.bo.Reservation;

public interface IAgenceDao extends IGenericDao<Agence> {
	
	List<Facture> getListeFacturesByAgence(long pFactureId);
	
	List<Reservation> getListReservationDateRetour(Long pAgenceId, Date dateRetour);

}
