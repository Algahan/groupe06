package com.adaming.myapp.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.adaming.myapp.bo.Voiture;
import com.adaming.myapp.service.IVoitureService;

@Component("voitureMb")
@ViewScoped
public class VoitureMb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * ctor
	 */
	public VoitureMb() {
		super();
		voiture = new Voiture();
	}

	//service
	@Inject
	private IVoitureService serviceVoiture;

	/**
	 * @param serviceVoiture the serviceVoiture to set
	 */
	public void setServiceVoiture(IVoitureService serviceVoiture) {
		this.serviceVoiture = serviceVoiture;
	}
	
	//stockages
	private long voitureId;
	private long agenceId;
	private Voiture voiture = new Voiture();;
	private List<Voiture> listeVoitures;

	//methodes
	/**
	 * get all voitures
	 */
	public void getAllVoitures(){
		
		setListeVoitures(serviceVoiture.getAll());
	}
	
	/**
	 * ajouter nvelle voiture
	 */
	public void ajouterNouvelleVoiture(){
		
		Voiture voitureTemp = voiture;
		
		serviceVoiture.add(voitureTemp, agenceId);
	}
	
	/**
	 * trouver voiture par id
	 */
	public void trouverVoitureById(){
		
		setVoiture(serviceVoiture.getById(voitureId));
	}
	
	// getters / setters
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
