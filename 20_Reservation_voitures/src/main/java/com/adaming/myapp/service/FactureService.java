package com.adaming.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.bo.Facture;
import com.adaming.myapp.dao.IFactureDao;

//@Service
@Transactional
public class FactureService implements IFactureService {

//	@Inject
	private IFactureDao dao;
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(IFactureDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Facture> getAll() {

		return dao.getAll();
	}

	@Override
	public Facture add(Facture pFacture) {

		return dao.add(pFacture);
	}

	@Override
	public Facture update(Facture pFacture) {
		
		return dao.update(pFacture);
	}

	@Override
	public Facture delete(long pFactureId) {

		return dao.delete(pFactureId);
	}

	@Override
	public Facture getById(long pFactureId) {

		return dao.getById(pFactureId);
	}

	@Override
	public String imprimerFacture() {
		// TODO Auto-generated method stub
		return null;
	}

}
