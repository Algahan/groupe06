package com.adaming.myapp.dao;

import com.adaming.myapp.bo.Client;

public interface IClientDao extends IGenericDao<Client> {
	
	Client add(Client pClient, long pAgenceId);

}
