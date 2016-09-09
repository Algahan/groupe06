package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Facture;

@Repository
public class AgenceDao implements IAgenceDao{

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
	public List<Agence> getAll() {
		
		String hqlReq = "from Agence";
		
		Query query = em.createQuery(hqlReq);
		log.info("=========== Agence getAll : " + query.getResultList().size());
		
		return query.getResultList();
	}

	@Override
	public Agence add(Agence pAgence) {
		
		em.persist(pAgence);
		log.info("=========== Agence add :" + pAgence.getIdAgence());
		
		return pAgence;
	}

	@Override
	public Agence update(Agence pAgence) {

		em.merge(pAgence);
		
		log.info("=========== Agence update : " + pAgence.getIdAgence());
		
		return pAgence;
	}

	@Override
	public Agence delete(long pAgenceId) {

		Agence pAgence = getById(pAgenceId);
		
		em.remove(pAgence);
		
		log.info("=========== Agence delete : " + pAgenceId);
		
		return pAgence;
	}

	@Override
	public Agence getById(long pAgenceId) {
		
		Agence pAgence = em.find(Agence.class, pAgenceId);
		log.info("=========== Agence getById : " + pAgence.getIdAgence());
		
		return pAgence;
	}

	@Override
	public List<Facture> getListeFacturesByAgence(long pFactureId) {
		
		String hqlReq = "from Reservation r where r.agence.idAgence=:x";
		
		Query query = em.createQuery(hqlReq);
		
		query.setParameter("x", pFactureId);
		
		List<Facture> listeFactures = query.getResultList();
		
		return listeFactures;
	}
	
	

}
