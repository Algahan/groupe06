package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.myapp.bo.Client;
import com.adaming.myapp.bo.Facture;

//@Repository
public class FactureDao implements IFactureDao {

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
	public List<Facture> getAll() {
		
		String hqlReq = "from Facture";
		
		Query query = em.createQuery(hqlReq);
		log.info("=========== Facture getAll : " + query.getResultList().size());
		
		return query.getResultList();
	}

	@Override
	public Facture add(Facture pFacture) {
		
		em.persist(pFacture);
		log.info("=========== Facture add :" + pFacture.getIdFacture());
		
		return pFacture;
	}

	@Override
	public Facture update(Facture pFacture) {

		em.merge(pFacture);
		
		log.info("=========== Facture update : " + pFacture.getIdFacture());
		
		return pFacture;
	}

	@Override
	public Facture delete(long pFactureId) {

		Facture pFacture = getById(pFactureId);
		
		em.remove(pFactureId);
		
		log.info("=========== Facture delete : " + pFactureId);
		
		return pFacture;
	}

	@Override
	public Facture getById(long pFactureId) {
		
		Facture pFacture = em.find(Facture.class, pFactureId);
		log.info("=========== Facture getById : " + pFactureId);
		
		return pFacture;
	}

}
