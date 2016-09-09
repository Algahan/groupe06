package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Facture;

public interface IAgenceDao extends IGenericDao<Agence> {
	
	List<Facture> getListeFacturesByAgence(long pFactureId);

}
