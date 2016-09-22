package com.adaming.myapp.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.adaming.myapp.utilitaire.Utilitaire;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reservation")
	private long idReservation;
	private Date dateDebut;
	private Date dateFin;
	private double prixTotal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id", referencedColumnName="id_client")
	private Client client;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="voiture_id", referencedColumnName="id_voiture")
	private Voiture voiture;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="facture_id", referencedColumnName="id_facture")
	private Facture facture;

	/**
	 * ctor vide
	 */
	public Reservation() {
		super();
	}

	/**
	 * @param dateDebut
	 * @param dateFin
	 */
	public Reservation(Date dateDebut, Date dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	/**
	 * @param idReservation
	 * @param dateDebut
	 * @param dateFin
	 */
	public Reservation(long idReservation, Date dateDebut, Date dateFin) {
		super();
		this.idReservation = idReservation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	/**
	 * @param dateDebut
	 * @param dateFin
	 * @param client
	 * @param voiture
	 */
	public Reservation(Date dateDebut, Date dateFin, Client client, Voiture voiture) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = client;
		this.voiture = voiture;
		calculerPrixTotal();
	}

	/**
	 * @param dateDebut
	 * @param dateFin
	 * @param prixTotal
	 * @param client
	 * @param voiture
	 * @param facture
	 */
	public Reservation(Date dateDebut, Date dateFin, Client client, Voiture voiture, Facture facture) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = client;
		this.voiture = voiture;
		this.facture = facture;
		calculerPrixTotal();
	}
	
	// méthodes
	/**
	 * calcul le prix Total via le prix de la voiture et les date de
	 * locations
	 */
	
	public void calculerPrixTotal(){
		
		long days = Utilitaire.NbJoursEntreDates(this.dateDebut, this.dateFin);
		this.prixTotal = days*this.voiture.getPrix();
	}
	
	// getters / setters
	/**
	 * @return the idReservation
	 */
	public long getIdReservation() {
		return idReservation;
	}

	/**
	 * @param idReservation the idReservation to set
	 */
	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the voiture
	 */
	public Voiture getVoiture() {
		return voiture;
	}

	/**
	 * @param voiture the voiture to set
	 */
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	/**
	 * @return the facture
	 */
	public Facture getFacture() {
		return facture;
	}

	/**
	 * @param facture the facture to set
	 */
	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	/**
	 * @return the prixTotal
	 */
	public double getPrixTotal() {
		return prixTotal;
	}

	/**
	 * @param prixTotal the prixTotal to set
	 */
	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

}
