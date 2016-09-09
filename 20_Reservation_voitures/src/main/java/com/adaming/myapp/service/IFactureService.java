package com.adaming.myapp.service;

import com.adaming.myapp.bo.Facture;

public interface IFactureService extends IGenericService<Facture> {
	
	String imprimerFacture();

}
