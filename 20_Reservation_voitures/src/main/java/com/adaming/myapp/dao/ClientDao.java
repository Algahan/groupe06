package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Client;

@Repository
public class ClientDao implements IClientDao {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	private Logger log = Logger.getLogger("");
	
	@Override
	public List<Client> getAll() {

		String hqlReq = "from Client";
		
		Query query = em.createQuery(hqlReq);
		log.info("=========== Client getAll : " + query.getResultList().size());
		
		return query.getResultList();
	}

	@Override
	public Client add(Client pClient) {
		
		em.persist(pClient);
		log.info("=========== Client add :" + pClient.getIdClient());
		
		return pClient;
	}

	@Override
	public Client update(Client pClient) {

		em.merge(pClient);
		
		log.info("=========== Client update : " + pClient.getIdClient());
		
		return pClient;
	}

	@Override
	public Client delete(long pClientId) {

		Client pClient = getById(pClientId);
		
		em.remove(pClient);
		
		log.info("=========== Client delete : " + pClientId);
		
		return pClient;
	}

	@Override
	public Client getById(long pClientId) {
		
		Client pClient = em.find(Client.class, pClientId);
		log.info("=========== Client getById : " + pClientId);
		
		return pClient;
	}

}
