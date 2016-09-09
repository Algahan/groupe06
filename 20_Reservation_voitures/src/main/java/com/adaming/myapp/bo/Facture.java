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

@Entity
public class Facture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_facture")
	private long idFacture;
	private Date dateFacturation;
	
	
	@OneToOne(mappedBy="facture", fetch=FetchType.LAZY)
	private Reservation reservation;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="agence_id", referencedColumnName="id_agence")
	private Agence agence;
	
	/**
	 * ctor vide
	 */
	public Facture() {
		super();
	}

	/**
	 * @param dateFacturation
	 */
	public Facture(Date dateFacturation) {
		super();
		this.dateFacturation = dateFacturation;
	}

	/**
	 * @param idFacture
	 * @param dateFacturation
	 */
	public Facture(long idFacture, Date dateFacturation) {
		super();
		this.idFacture = idFacture;
		this.dateFacturation = dateFacturation;
	}

	// Getter/Setters
	/**
	 * @return the idFacture
	 */
	public long getIdFacture() {
		return idFacture;
	}

	/**
	 * @param idFacture the idFacture to set
	 */
	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}

	/**
	 * @return the dateFacturation
	 */
	public Date getDateFacturation() {
		return dateFacturation;
	}

	/**
	 * @param dateFacturation the dateFacturation to set
	 */
	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	/**
	 * @return the reservation
	 */
	public Reservation getReservation() {
		return reservation;
	}

	/**
	 * @param reservation the reservation to set
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
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

}
