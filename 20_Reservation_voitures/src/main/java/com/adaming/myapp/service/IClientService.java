package com.adaming.myapp.service;

import com.adaming.myapp.bo.Client;

public interface IClientService extends IGenericService<Client>{
	
	Client add(Client pClient, long pAgenceId);

}
