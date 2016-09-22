package com.adaming.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.bo.Voiture;
import com.adaming.myapp.dao.IVoitureDao;

//@Service
@Transactional
public class VoitureService implements IVoitureService {

	private IVoitureDao dao;
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(IVoitureDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Voiture> getAll() {
		
		return dao.getAll();
	}

	@Override
	public Voiture add(Voiture pVoiture) {
		
		return dao.add(pVoiture);
	}

	@Override
	public Voiture update(Voiture pVoiture) {
		
		return dao.update(pVoiture);
	}

	@Override
	public Voiture delete(long pVoitureId) {
		
		return dao.delete(pVoitureId);
	}

	@Override
	public Voiture getById(long pVoitureId) {
		
		return dao.getById(pVoitureId);
	}

	@Override
	public Voiture add(Voiture pVoiture, long pAgenceId) {
		
		return dao.add(pVoiture, pAgenceId);
	}

}
