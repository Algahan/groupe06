package com.adaming.myapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Facture;
import com.adaming.myapp.bo.Reservation;
import com.adaming.myapp.bo.Voiture;
import com.adaming.myapp.dao.IAgenceDao;

@Service
public class AgenceService implements IAgenceService {

	@Autowired
	private IAgenceDao dao;
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(IAgenceDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Agence> getAll() {

		return dao.getAll();
	}

	@Override
	public Agence add(Agence pAgence) {
		
		return dao.add(pAgence);
	}

	@Override
	public Agence update(Agence pAgence) {

		return dao.update(pAgence);
	}

	@Override
	public Agence delete(long pAgenceId) {

		return dao.delete(pAgenceId);
	}

	@Override
	public Agence getById(long pAgenceId) {

		return dao.getById(pAgenceId);
	}

	@Override
	public double getChiffreAffaire(long pAgenceId, int pAnnee) {

		List<Facture> listeFactures = dao.getListeFacturesByAgence(pAgenceId);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		double chiffreAffaire = 0;
		int pAnneePrec = pAnnee - 1;
		int pAnneeSuiv = pAnnee + 1;
		
		Date dateDebutAnnee = null;
		Date dateFinAnnee = null;
		
		try {
			
			dateDebutAnnee = format.parse("31/12/" + pAnneePrec);
			dateFinAnnee = format.parse("01/01/" + pAnneeSuiv);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		for (Facture facture : listeFactures) {
			
			if (facture.getDateFacturation().after(dateDebutAnnee) && facture.getDateFacturation().before(dateFinAnnee)) {
				
				long diff = facture.getReservation().getDateFin().getTime() -  facture.getReservation().getDateDebut().getTime();				
				long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				
				chiffreAffaire = chiffreAffaire + days*facture.getReservation().getPrixTotal();
			}
		}
		
		return chiffreAffaire;
	}

	@Override
	public List<Voiture> getVoituresDisponibles(long pAgenceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getListeReservations(long pAgenceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
