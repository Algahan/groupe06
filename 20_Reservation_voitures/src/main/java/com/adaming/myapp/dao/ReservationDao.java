package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.myapp.bo.Facture;
import com.adaming.myapp.bo.Reservation;

@Repository
public class ReservationDao implements IReservationDao {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	private Logger log = Logger.getLogger("");

	@Override
	public List<Reservation> getAll() {
		
		String hqlReq = "from Reservation";
		
		Query query = em.createQuery(hqlReq);
		log.info("=========== Reservation getAll : " + query.getResultList().size());
		
		return query.getResultList();
	}

	@Override
	public Reservation add(Reservation pReservation) {
		
		em.persist(pReservation);
		log.info("=========== Reservation add :" + pReservation.getIdReservation());
		
		return pReservation;
	}

	@Override
	public Reservation update(Reservation pReservation) {

		em.merge(pReservation);
		
		log.info("=========== Reservation update : " + pReservation.getIdReservation());
		
		return pReservation;
	}

	@Override
	public Reservation delete(long pReservationId) {

		Reservation pReservation = getById(pReservationId);
		
		em.remove(pReservation);
		
		log.info("=========== Reservation delete : " + pReservationId);
		
		return pReservation;
	}

	@Override
	public Reservation getById(long pReservationId) {
		
		Reservation pReservation = em.find(Reservation.class, pReservationId);
		log.info("=========== Reservation getById : " + pReservationId);
		
		return pReservation;
	}

}
