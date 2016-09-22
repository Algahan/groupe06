package com.adaming.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.bo.Reservation;
import com.adaming.myapp.dao.IReservationDao;

//@Service
@Transactional
public class ReservationService implements IReservationService {

	private IReservationDao dao;
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(IReservationDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Reservation> getAll() {

		return dao.getAll();
	}

	@Override
	public Reservation add(Reservation pReservation) {
		
		return dao.add(pReservation);
	}

	@Override
	public Reservation update(Reservation pReservation) {
		
		return dao.update(pReservation);
	}

	@Override
	public Reservation delete(long pReservationId) {
		
		return dao.delete(pReservationId);
	}

	@Override
	public Reservation getById(long pReservationId) {
		
		return dao.getById(pReservationId);
	}

	@Override
	public Reservation add(Reservation pReservation, long pClientId, long pVoitureId, long pAgenceId) {
		
		return dao.add(pReservation, pClientId, pVoitureId, pAgenceId);
	}

}
