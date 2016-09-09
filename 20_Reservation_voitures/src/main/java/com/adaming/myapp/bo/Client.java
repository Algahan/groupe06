package com.adaming.myapp.bo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private long idClient;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private Date datePermis;
	private String telephone;
	private String adresse;
	private String mail;
	
	@OneToMany(mappedBy="client", cascade = CascadeType.REMOVE)
	private List<Reservation> listeReservations;

	/**
	 * ctor vide
	 */
	public Client() {
		super();
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param datePermis
	 * @param telephone
	 * @param adresse
	 * @param mail
	 */
	public Client(String nom, String prenom, Date dateDeNaissance, Date datePermis, String telephone, String adresse,
			String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.datePermis = datePermis;
		this.telephone = telephone;
		this.adresse = adresse;
		this.mail = mail;
	}

	/**
	 * @param idClient
	 * @param nom
	 * @param prenom
	 * @param dateDeNaissance
	 * @param datePermis
	 * @param telephone
	 * @param adresse
	 * @param mail
	 */
	public Client(long idClient, String nom, String prenom, Date dateDeNaissance, Date datePermis, String telephone,
			String adresse, String mail) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.datePermis = datePermis;
		this.telephone = telephone;
		this.adresse = adresse;
		this.mail = mail;
	}

	/**
	 * @return the idClient
	 */
	public long getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(long idClient) {
		this.idClient = idClient;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the dateDeNaissance
	 */
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * @param dateDeNaissance the dateDeNaissance to set
	 */
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * @return the datePermis
	 */
	public Date getDatePermis() {
		return datePermis;
	}

	/**
	 * @param datePermis the datePermis to set
	 */
	public void setDatePermis(Date datePermis) {
		this.datePermis = datePermis;
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
