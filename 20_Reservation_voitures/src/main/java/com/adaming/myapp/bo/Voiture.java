package com.adaming.myapp.bo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Voiture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_voiture")
	private long idVoiture;
	private String kilometrage;
	private String model;
	private int annee;
	private double prix;
	private String imatriculation;
	
	@ManyToOne
	@JoinColumn(name="agence_id", referencedColumnName="id_agence")
	private Agence agence;
	
	@OneToMany(mappedBy="voiture")
	private List<Reservation> listeReservations;
	
	/**
	 * 
	 */
	public Voiture() {
		super();
	}

	/**
	 * @param kilometrage
	 * @param model
	 * @param annee
	 * @param prix
	 * @param imatriculation
	 */
	public Voiture(String kilometrage, String model, int annee, double prix, String imatriculation) {
		super();
		this.kilometrage = kilometrage;
		this.model = model;
		this.annee = annee;
		this.prix = prix;
		this.imatriculation = imatriculation;
	}

	/**
	 * @param idVoiture
	 * @param kilometrage
	 * @param model
	 * @param annee
	 * @param prix
	 * @param imatriculation
	 */
	public Voiture(long idVoiture, String kilometrage, String model, int annee, double prix, String imatriculation) {
		super();
		this.idVoiture = idVoiture;
		this.kilometrage = kilometrage;
		this.model = model;
		this.annee = annee;
		this.prix = prix;
		this.imatriculation = imatriculation;
	}

	/**
	 * @param kilometrage
	 * @param model
	 * @param annee
	 * @param prix
	 * @param imatriculation
	 * @param agence
	 */
	public Voiture(String kilometrage, String model, int annee, double prix, String imatriculation, Agence agence) {
		super();
		this.kilometrage = kilometrage;
		this.model = model;
		this.annee = annee;
		this.prix = prix;
		this.imatriculation = imatriculation;
		this.agence = agence;
	}

	// getters // setters
	/**
	 * @return the idVoiture
	 */
	public long getIdVoiture() {
		return idVoiture;
	}

	/**
	 * @param idVoiture the idVoiture to set
	 */
	public void setIdVoiture(long idVoiture) {
		this.idVoiture = idVoiture;
	}

	/**
	 * @return the kilometrage
	 */
	public String getKilometrage() {
		return kilometrage;
	}

	/**
	 * @param kilometrage the kilometrage to set
	 */
	public void setKilometrage(String kilometrage) {
		this.kilometrage = kilometrage;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the imatriculation
	 */
	public String getImatriculation() {
		return imatriculation;
	}

	/**
	 * @param imatriculation the imatriculation to set
	 */
	public void setImatriculation(String imatriculation) {
		this.imatriculation = imatriculation;
	}

	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}

	/**
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/**
	 * @return the listeReservations
	 */
	public List<Reservation> getListeReservations() {
		return listeReservations;
	}

	/**
	 * @param listeReservations the listeReservations to set
	 */
	public void setListeReservations(List<Reservation> listeReservations) {
		this.listeReservations = listeReservations;
	}
	
	

}
