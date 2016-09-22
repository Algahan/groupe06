package com.adaming.myapp.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.adaming.myapp.bo.Facture;
import com.adaming.myapp.service.IFactureService;

@Component
@ViewScoped
public class FactureMb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//service
	@Inject
	private IFactureService serviceFacture;

	/**
	 * @param serviceFacture the serviceFacture to set
	 */
	public void setServiceFacture(IFactureService serviceFacture) {
		this.serviceFacture = serviceFacture;
	}
	
	//stockages
	private long idFacture;
	private Facture facture;
	private List<Facture> listeFactures;
	private Date dateFacturation;
	
	//methodes
	/**
	 * get all factures
	 */
	public void getAll(){
		
		setListeFactures(serviceFacture.getAll());
	}
	
	/**
	 * maj la date de paiement
	 */
	public void payerFacture(){
		
		serviceFacture.update(facture);
	}
	
	/**
	 * imprime ou enregristre un une facture sous format pdf
	 */
	public void imprimerFacture(){
		
	}

	// getters / setters
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
