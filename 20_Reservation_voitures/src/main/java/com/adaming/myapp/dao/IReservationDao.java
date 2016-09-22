package com.adaming.myapp.dao;

import com.adaming.myapp.bo.Reservation;

public interface IReservationDao extends IGenericDao<Reservation> {

	Reservation add(Reservation pReservation, long pClientId, long pVoitureId, long pAgenceId);
	

}
