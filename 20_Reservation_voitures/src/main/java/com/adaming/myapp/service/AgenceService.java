package com.adaming.myapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Facture;
import com.adaming.myapp.bo.Reservation;
import com.adaming.myapp.bo.Voiture;
import com.adaming.myapp.dao.IAgenceDao;
import com.adaming.myapp.utilitaire.Utilitaire;

//@Service
@Transactional
public class AgenceService implements IAgenceService {

	// @Inject
	private IAgenceDao dao;

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(IAgenceDao dao) {
		this.dao = dao;
	}

	private Logger log = Logger.getLogger("");

	// méthodes
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

		try {

			List<Facture> listeFactures = dao.getListeFacturesByAgence(pAgenceId);
			log.info(" ============ getListeFacturesByAgence : " + listeFactures.size());

			double chiffreAffaire = 0;
			int pAnneePrec = pAnnee - 1;
			int pAnneeSuiv = pAnnee + 1;

			Date dateDebutAnnee = Utilitaire.stringToDate("31/12/" + pAnneePrec);
			Date dateFinAnnee = Utilitaire.stringToDate("01/01/" + pAnneeSuiv);
			log.info(" ============= Reussite du parse des dates");

			for (Facture facture : listeFactures) {

				if (facture.getDateFacturation() != null) {

					if (facture.getDateFacturation().after(dateDebutAnnee)
							&& facture.getDateFacturation().before(dateFinAnnee)) {

						chiffreAffaire = chiffreAffaire + facture.getReservation().getPrixTotal();

					}
				}
			}
			log.info(" ============= calcul chiffre d'affaire : " + chiffreAffaire);

			return chiffreAffaire;

		} catch (NullPointerException e) {

			return 0;
		}
	}

	@Override
	public List<Voiture> getVoituresDisponibles(long pAgenceId, Date dateDebut, Date dateFin) {

		Agence pAgence = dao.getById(pAgenceId);

		List<Reservation> listeResas = pAgence.getListeReservations();
		List<Voiture> listeVoituresDisponibles = pAgence.getListeVoitures();

		// cherche les chmabre indispo à la date
		for (Reservation reservation : listeResas) {

			if (!dateDebut.after(reservation.getDateFin()) && !dateFin.before(reservation.getDateDebut())) {

				listeVoituresDisponibles.remove(reservation.getVoiture());
			} // end if
		} // end for

		if (listeVoituresDisponibles != null) {

			log.info(" ============ liste voitures dispo : " + listeVoituresDisponibles.size());
		}

		return listeVoituresDisponibles;
	}

	@Override
	public List<Reservation> getListeReservations(long pAgenceId) {

		Agence pAgence = getById(pAgenceId);

		return pAgence.getListeReservations();
	}

	@Override
	public List<Voiture> getListeVoituresRetour(long pAgenceId, Date dateRetour) {

		List<Reservation> listeReservationRetour = dao.getListReservationDateRetour(pAgenceId, dateRetour);

		List<Voiture> listeVoituresRetour = new ArrayList<Voiture>();

		for (Reservation reservation : listeReservationRetour) {

			listeVoituresRetour.add(reservation.getVoiture());
		}

		return listeVoituresRetour;
	}

}
