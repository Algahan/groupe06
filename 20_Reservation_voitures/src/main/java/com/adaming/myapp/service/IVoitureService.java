package com.adaming.myapp.service;

import com.adaming.myapp.bo.Voiture;

public interface IVoitureService extends IGenericService<Voiture> {

	Voiture add(Voiture pVoiture, long pAgenceId);
}
