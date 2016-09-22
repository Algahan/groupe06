package com.adaming.myapp.service;

import com.adaming.myapp.bo.Reservation;

public interface IReservationService extends IGenericService<Reservation> {
	
	Reservation add(Reservation pReservation, long pClientId, long pVoitureId, long pAgenceId);

}
