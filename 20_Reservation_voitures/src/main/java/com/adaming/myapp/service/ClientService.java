package com.adaming.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.bo.Client;
import com.adaming.myapp.dao.IClientDao;

//@Service
@Transactional
public class ClientService implements IClientService{

//	@Inject
	private IClientDao dao;
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(IClientDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Client> getAll() {

		return dao.getAll();
	}

	@Override
	public Client add(Client pClient) {

		return dao.add(pClient);
	}

	@Override
	public Client update(Client pClient) {

		return dao.update(pClient);
	}

	@Override
	public Client delete(long pClientId) {

		return dao.delete(pClientId);
	}

	@Override
	public Client getById(long pClientId) {

		return dao.getById(pClientId);
	}

	@Override
	public Client add(Client pClient, long pAgenceId) {
		
		return dao.add(pClient, pAgenceId);
	}

}
