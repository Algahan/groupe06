package com.adaming.myapp.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Agence {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agence")
	private long idAgence;
	private String nom;
	private String adresse;
	private String telephone;
	private String mail;
	
	@OneToMany(mappedBy="agence", cascade = CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Voiture> listeVoitures;
	
	@OneToMany(mappedBy="agence", cascade = CascadeType.REMOVE, fetch=FetchType.LAZY)
	private List<Facture> listeFactures;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="agence_reservation",
	joinColumns=
	    @JoinColumn(name="reservation_id"),
	    inverseJoinColumns=
	    @JoinColumn(name="agence_id"))
	private List<Reservation> listeReservations;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="agence_client",
	joinColumns=
	    @JoinColumn(name="client_id"),
	    inverseJoinColumns=
	    @JoinColumn(name="agence_id"))
	private List<Client> listeClients;
	
	/**
	 * 
	 */
	public Agence() {
		super();
	}

	/**
	 * @param nom
	 * @param adresse
	 * @param telephone
	 * @param mail
	 */
	public Agence(String nom, String adresse, String telephone, String mail) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
	}

	/**
	 * @param idAgence
	 * @param nom
	 * @param adresse
	 * @param telephone
	 * @param mail
	 */
	public Agence(long idAgence, String nom, String adresse, String telephone, String mail) {
		super();
		this.idAgence = idAgence;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
	}

	/**
	 * @return the idAgence
	 */
	public long getIdAgence() {
		return idAgence;
	}

	/**
	 * @param idAgence the idAgence to set
	 */
	public void setIdAgence(long idAgence) {
		this.idAgence = idAgence;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the listeVoitures
	 */
	public List<Voiture> getListeVoitures() {
		return listeVoitures;
	}

	/**
	 * @param listeVoitures the listeVoitures to set
	 */
	public void setListeVoitures(List<Voiture> listeVoitures) {
		this.listeVoitures = listeVoitures;
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

	/**
	 * @return the listeFactures
	 */
	public List<Facture> getListeFactures() {
		return listeFactures;
	}

	/**
	 * @param listeFactures the listeFactures to set
	 */
	public void setListeFactures(List<Facture> listeFactures) {
		this.listeFactures = listeFactures;
	}

	/**
	 * @return the listeClients
	 */
	public List<Client> getListeClients() {
		return listeClients;
	}

	/**
	 * @param listeClients the listeClients to set
	 */
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}
	
	

}
