package com.adaming.myapp.managedbean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Component;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Client;
import com.adaming.myapp.bo.Reservation;
import com.adaming.myapp.bo.Voiture;
import com.adaming.myapp.service.IAgenceService;
import com.adaming.myapp.service.IReservationService;

@Component("agenceMb")
@ViewScoped
public class AgenceMb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//service
	@Inject
	private IAgenceService serviceAgence;
	@Inject
	private IReservationService serviceReservation;

	/**
	 * @param serviceAgence the serviceAgence to set
	 */
	public void setServiceAgence(IAgenceService serviceAgence) {
		this.serviceAgence = serviceAgence;
	}
	
	/**
	 * @param serviceReservation the serviceReservation to set
	 */
	public void setServiceReservation(IReservationService serviceReservation) {
		this.serviceReservation = serviceReservation;
	}
	
//	@ManagedProperty(value="reservationMb")
//	private ReservationMb reservationMb;
//
//	/**
//	 * @return the reservationMb
//	 */
//	public ReservationMb getReservationMb() {
//		return reservationMb;
//	}
//
//	/**
//	 * @param reservationMb the reservationMb to set
//	 */
//	public void setReservationMb(ReservationMb reservationMb) {
//		this.reservationMb = reservationMb;
//	}

	//stockages
	private List<Agence> listeAgences;
	private Agence agence  = new Agence();
	private List<Voiture> listeVoitures;
	private List<Reservation> listeReservations;
	private List<Client> listeClients;
	private double chiffreAffaire;
	private Date dateDebut;
	private Date dateFin;
	private int annee;
	
	private String message;
	private String messageAdd;

	private long agenceId;
	private String agenceNom;
	private String agenceAdresse;
	private String agenceTelephone;
	private String agenceMail;
	
	private long clientId;
	private long voitureId;
	private Reservation reservation = new Reservation();
	
	/**
	 * ctor
	 */
	public AgenceMb() {
		super();
		
	}

	//méthodes
	/**
	 * maj liste agences
	 */
	public void getAll(){
		
		setListeAgences(serviceAgence.getAll());
	}
	
	@PostConstruct
	public void init(){
		agence = new Agence();
		listeVoitures = new ArrayList<Voiture>();
		listeReservations = new ArrayList<Reservation>();
		reservation = new Reservation();
		listeClients = new ArrayList<Client>();
		message = "";
		setListeAgences(serviceAgence.getAll());
	}
	
	/**
	 * ajoute nouvelle agence
	 */
	public void ajouterAgence() {
		
		messageAdd = "";
		
		agence.setIdAgence(0);
		
		Agence agenceTemp = agence;
		
		serviceAgence.add(agenceTemp);
		
		messageAdd = "Agence enregistrée.";
		
		getAll();
	}
	
	/**
	 * maj agence
	 */
	public void updateAgence(){
		
		serviceAgence.update(agence);
		
		getAll();
	}
	
	/**
	 * trouve une agence selon id
	 */
	public void trouverAgenceById() {
		
		message = "";
		
		try {
			
			setAgence(serviceAgence.getById(agenceId));
			
		} catch (Exception e) {
			message = "ID inconnu.";
		}
		
		if (agence == null) {

			agence = new Agence();

			message = "ID inconnu.";
		}
		
	}
	
	/**
	 * renvois les détails d'une agence
	 * @param event
	 */
	public void getAgenceDetails(ActionEvent event) {
		
		UIParameter cp = (UIParameter) event.getComponent().findComponent("agenceId");
		long pAgenceId = Long.parseLong(cp.getValue().toString());
		
		setAgence(serviceAgence.getById(pAgenceId));
	}
	
	/**
	 * calcule chiffre d'affaire
	 */
	public void calculerChiffreAffaire(){
	
		setChiffreAffaire(serviceAgence.getChiffreAffaire(agenceId, annee));
	}
	
	/**
	 * obtention de la liste des voitures disponibles par agence
	 * à la date indiquée
	 */
	public String obtenirVoituresDisponibles(){
		
		message = "";
		
		if (dateDebut.before(dateFin)) {
			
			setListeVoitures(serviceAgence.getVoituresDisponibles(agenceId, dateDebut, dateFin));
			
			return "/pages/choixvehicule.xhtml";
			
		} else {
			
			message = "Dates incorrectes.";
			
			return "#";
		}
		
	}
	
	/**
	 * obtenir liste reservations par agences
	 */
	public void obtenirListeReservations(){
		
		try {
			
			setListeReservations(serviceAgence.getListeReservations(agenceId));
			
		} catch (NullPointerException e) {
			message = "ID inconnu.";
		}
		
	}
	
	/**
	 * obtention de la liste de voiture retournant le jour indiqué
	 * et par agence
	 */
	public void obtenirListeVoituresRetour() {
		
		setListeVoitures(serviceAgence.getListeVoituresRetour(agenceId, dateFin));
	}
	
	/**
	 * obtention de la liste client par agence
	 */
	public void obtenirListeClients(){
		
		message="";
		
		try {
			
			setListeClients(serviceAgence.getById(agenceId).getListeClients());
			
		} catch (Exception e) {
			message ="ID inconnu.";
		}
		
	}
	
	/**
	 * méthode pour le calendrier
	 * @param event
	 */
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
	
	/**
	 * crée une nouvelle reservation via le client, une voiture
	 * et maj le client
	 */
	public String ajouterNouvelleReservation(){
		
		reservation = new Reservation(dateDebut, dateFin);
		
		reservation = serviceReservation.add(reservation, clientId, voitureId, agenceId);
		
		return "/pages/recapitulatif.xhtml";
	}
	
	/**
	 * permet le transfert de données entre agenceMb et reservationMb
	 * @param event
	 * @return
	 */
	public void stockageAvantPaiement(ActionEvent event){
		
		UIParameter cp = (UIParameter) event.getComponent().findComponent("voitureId");
		setVoitureId(Long.parseLong(cp.getValue().toString()));
		
//		ReservationMb resaBeanTemp = new ReservationMb();
//		
//		UIParameter cp = (UIParameter) event.getComponent().findComponent("voitureId");
//		resaBeanTemp.setVoitureId(Long.parseLong(cp.getValue().toString()));
//		
//		resaBeanTemp.setAgenceId(agenceId);
//		
//		Reservation resa = new Reservation(dateDebut, dateFin);
//		
//		resaBeanTemp.setReservation(resa);
//		
//		setReservationMb(resaBeanTemp);
			
	}
	
	/**
	 * reset les paramètres
	 */
	public void reset(){
		
		dateDebut = new Date();
		dateFin = new Date();
		message = "";
		
	}
	
	// getters / setters
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
	 * @return the chiffreAffaire
	 */
	public double getChiffreAffaire() {
		return chiffreAffaire;
	}
	/**
	 * @param chiffreAffaire the chiffreAffaire to set
	 */
	public void setChiffreAffaire(double chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the listeAgences
	 */
	public List<Agence> getListeAgences() {
		return listeAgences;
	}

	/**
	 * @param listeAgences the listeAgences to set
	 */
	public void setListeAgences(List<Agence> listeAgences) {
		this.listeAgences = listeAgences;
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
	 * @return the messageAdd
	 */
	public String getMessageAdd() {
		return messageAdd;
	}

	/**
	 * @param messageAdd the messageAdd to set
	 */
	public void setMessageAdd(String messageAdd) {
		this.messageAdd = messageAdd;
	}

	/**
	 * @return the agenceNom
	 */
	public String getAgenceNom() {
		return agenceNom;
	}

	/**
	 * @param agenceNom the agenceNom to set
	 */
	public void setAgenceNom(String agenceNom) {
		this.agenceNom = agenceNom;
	}

	/**
	 * @return the agenceAdresse
	 */
	public String getAgenceAdresse() {
		return agenceAdresse;
	}

	/**
	 * @param agenceAdresse the agenceAdresse to set
	 */
	public void setAgenceAdresse(String agenceAdresse) {
		this.agenceAdresse = agenceAdresse;
	}

	/**
	 * @return the agenceTelephone
	 */
	public String getAgenceTelephone() {
		return agenceTelephone;
	}

	/**
	 * @param agenceTelephone the agenceTelephone to set
	 */
	public void setAgenceTelephone(String agenceTelephone) {
		this.agenceTelephone = agenceTelephone;
	}

	/**
	 * @return the agenceMail
	 */
	public String getAgenceMail() {
		return agenceMail;
	}

	/**
	 * @param agenceMail the agenceMail to set
	 */
	public void setAgenceMail(String agenceMail) {
		this.agenceMail = agenceMail;
	}
}
