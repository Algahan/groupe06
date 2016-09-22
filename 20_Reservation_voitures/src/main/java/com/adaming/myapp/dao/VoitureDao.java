package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Facture;
import com.adaming.myapp.bo.Voiture;

//@Repository
public class VoitureDao implements IVoitureDao {

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
	public List<Voiture> getAll() {
		
		String hqlReq = "from Voiture";
		
		Query query = em.createQuery(hqlReq);
		log.info("=========== Voiture getAll : " + query.getResultList().size());
		
		return query.getResultList();
	}

	@Override
	public Voiture add(Voiture pVoiture) {
		
		em.persist(pVoiture);
		log.info("=========== Voiture add :" + pVoiture.getIdVoiture());
		
		return pVoiture;
	}

	@Override
	public Voiture update(Voiture pVoiture) {

		em.merge(pVoiture);
		
		log.info("=========== Voiture update : " + pVoiture.getIdVoiture());
		
		return pVoiture;
	}

	@Override
	public Voiture delete(long pVoitureId) {

		Voiture pVoiture = getById(pVoitureId);
		
		em.remove(pVoiture);
		
		log.info("=========== Voiture delete : " + pVoitureId);
		
		return pVoiture;
	}

	@Override
	public Voiture getById(long pVoitureId) {
		
		Voiture pVoiture = em.find(Voiture.class, pVoitureId);
		log.info("=========== Voiture getById : " + pVoitureId);
		
		return pVoiture;
	}

	@Override
	public Voiture add(Voiture pVoiture, long pAgenceId) {

		Agence pAgence = em.find(Agence.class, pAgenceId);
		
		pVoiture.setAgence(pAgence);
		
		em.persist(pVoiture);
		
		return pVoiture;
	}

}
