package com.adaming.myapp.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.adaming.myapp.bo.Reservation;
import com.adaming.myapp.service.IReservationService;

@Component("reservationMb")
@ViewScoped
public class ReservationMb implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//service
	@Inject
	private IReservationService serviceReservation;
	
	/**
	 * @param serviceReservation the serviceReservation to set
	 */
	public void setServiceReservation(IReservationService serviceReservation) {
		this.serviceReservation = serviceReservation;
	}

	/**
	 * @return the serviceReservation
	 */
	public IReservationService getServiceReservation() {
		return serviceReservation;
	}

	//stockages
	private long reservationId;
	private long agenceId;
	private long clientId;
	private long voitureId;
	private Reservation reservation;
	private List<Reservation> listeReservations;
	private String message;

	//methodes
	/**
	 * get all reservations
	 */
	public void getAll(){
		
		setListeReservations(serviceReservation.getAll());
	}
	
	/**
	 * crée une nouvelle reservation via le client, une voiture
	 * et maj le client
	 */
	public String ajouterNouvelleReservation(){
		
		Reservation resaTemp = reservation;
		
		serviceReservation.add(resaTemp, clientId, voitureId, agenceId);
		
		getAll();
		
		return "/pages/recapitulatif.xhtml";
		
	}
	
	/**
	 * get reservation selon id
	 */
	public void trouverReservationById(){
		
		setReservation(serviceReservation.getById(reservationId));
	}
	
	// getters / setters
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the reservationId
	 */
	public long getReservationId() {
		return reservationId;
	}

	/**
	 * @param reservationId the reservationId to set
	 */
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * @return the agenceId
	 */
	public long getAgenceId() {
		return agenceId;
	}

	/**
	 * @param agenceId the agenceId to set
	 */
	public void setAgenceId(long agenceId) {
		this.agenceId = agenceId;
	}

	/**
	 * @return the clientId
	 */
	public long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the voitureId
	 */
	public long getVoitureId() {
		return voitureId;
	}

	/**
	 * @param voitureId the voitureId to set
	 */
	public void setVoitureId(long voitureId) {
		this.voitureId = voitureId;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	

}
