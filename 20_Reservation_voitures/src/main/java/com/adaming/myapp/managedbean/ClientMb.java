package com.adaming.myapp.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Client;
import com.adaming.myapp.bo.Reservation;
import com.adaming.myapp.service.IClientService;

@Component("clientMb")
@ViewScoped
public class ClientMb implements Serializable{

	
	/**
	 * 
	 */
	public ClientMb() {
		super();
		
		client = new Client();	
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//service
	@Inject
	private IClientService serviceClient;
	
	/**
	 * @param serviceClient the serviceClient to set
	 */
	public void setServiceClient(IClientService serviceClient) {
		this.serviceClient = serviceClient;
	}
	//stockages
	private long idAgence;
	private Client client;
	private List<Client> listeClients;
	private List<Reservation> listeReservations;
	
	/*attributs client*/
	private long idClient;
	private String nomClient;
	private String prenomClient;
	private Date dateNaissance;
	private Date datePermis;
	@Pattern(regexp="[0-9]+", message = "Ne doit contenir que des numéros." )
	private String telephone;
	private String mail;
	
	private String message;

	//methodes
	@PostConstruct
	public void init(){
		client = new Client();
	}
	
	/**
	 * get all clients
	 */
	public void getAll(){
		
		setListeClients(serviceClient.getAll());
	}
	
	/**
	 * ajouter un nouveau client
	 */
	public void ajouterNouveauClient(){
		
		message="";
		
		Client clientTemp = client;
		
		try {
			
			serviceClient.add(clientTemp, idAgence);
			message = "Client enregistré.";
			
		} catch (NullPointerException e) {
			message = "Erreur lors de l'enregistrement.";
		}
		getAll();
		
	}
	
	/**
	 * maj client
	 */
	public void updateClient(){
		
		serviceClient.update(client);
		
		getAll();
	}
	
	/**
	 * trouver client par id
	 */
	public void trouverClientById(){
		
		message ="";
		
		try {
			
			setClient(serviceClient.getById(idClient));
			
		} catch (NullPointerException e) {
			message = "ID inconnu.";
		}
		
		if (client == null) {

			client = new Client();
			message = "ID inconnu.";
		}
		
	}
	
	/**
	 * obtenir les reservations/factures par client
	 */
	public void obtenirReservations(){
		
		setListeReservations(serviceClient.getById(idClient).getListeReservations());
	}
	
	// getters / setters
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}

	/**
	 * @param nomClient the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/**
	 * @return the prenomClient
	 */
	public String getPrenomClient() {
		return prenomClient;
	}

	/**
	 * @param prenomClient the prenomClient to set
	 */
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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
	

}
