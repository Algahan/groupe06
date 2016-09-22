package com.adaming.myapp;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.bo.Client;
import com.adaming.myapp.bo.Facture;
import com.adaming.myapp.bo.Reservation;
import com.adaming.myapp.bo.Voiture;
import com.adaming.myapp.service.IAgenceService;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.IFactureService;
import com.adaming.myapp.service.IReservationService;
import com.adaming.myapp.service.IVoitureService;
import com.adaming.myapp.utilitaire.Utilitaire;

public class AgenceServiceTest {

	private static ClassPathXmlApplicationContext context;
	
	private static IAgenceService serviceAgence;
	private static IClientService serviceClient;
	private static IFactureService serviceFacture;
	private static IReservationService serviceReservation;
	private static IVoitureService serviceVoiture;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		serviceAgence = (IAgenceService) context.getBean("serviceAgence");
		serviceClient = (IClientService) context.getBean("serviceClient");
		serviceFacture = (IFactureService) context.getBean("serviceFacture");
		serviceReservation = (IReservationService) context.getBean("serviceReservation");
		serviceVoiture = (IVoitureService) context.getBean("serviceVoiture");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Test
	public void testGetAll() {
		List<Agence> la = serviceAgence.getAll();
		
		assertTrue(la.size() > 0);
	}

	@Test
	@Before
	@Ignore
	public void testAdd() {
		
		Agence agenceAdd = new Agence("MiguelLocation", "Paris", "555-777", "mds@gmail.com");
		serviceAgence.add(agenceAdd);
		Agence pAgence = serviceAgence.getById(1L);
		
		Client clientAdd = new Client("Da Silva", "Miguel", Utilitaire.stringToDate("04/05/1975"),
				Utilitaire.stringToDate("27/04/1998"), "555-898", "Paris", "supermiguel@orange.fr");
		serviceClient.add(clientAdd, agenceAdd.getIdAgence());
		
		Voiture voitureAdd1 = new Voiture("55785845", "Lada", 1850, 50, "65f5d6d5");
		Voiture voitureAdd2 = new Voiture("5585845", "Lada", 1851, 45, "75434355");
		
		serviceVoiture.add(voitureAdd1, agenceAdd.getIdAgence());
		serviceVoiture.add(voitureAdd2, agenceAdd.getIdAgence());
		
		//reservation
		Reservation reservationAdd = new Reservation(Utilitaire.stringToDate("01/02/2016"), Utilitaire.stringToDate("05/03/2016"));
		Reservation reservationAdd2 = new Reservation(Utilitaire.stringToDate("01/05/2016"), Utilitaire.stringToDate("05/05/2016"));
		
		serviceReservation.add(reservationAdd, 1L, 1L, 1L);
		serviceReservation.add(reservationAdd2, 1L, 1L, 1L);
		
		//paiement
		Facture pFacture = serviceFacture.getById(1L);
		pFacture.setDateFacturation(Utilitaire.stringToDate("08/09/2016"));
		serviceFacture.update(pFacture);
		
		Facture pFacture2 = serviceFacture.getById(2L);
		pFacture2.setDateFacturation(Utilitaire.stringToDate("14/10/2016"));
		serviceFacture.update(pFacture2);
		
	}

	@Test
	@Ignore
	public void testUpdate() {

		Agence pAgence = serviceAgence.getById(1L);
		Client pClient = serviceClient.getById(1L);
		Reservation pReservation = serviceReservation.getById(1L);
		pAgence.ajouterNouveauClient(pClient);
		pAgence.ajouterNouvelleReservation(pReservation);
		Agence pAgenceTest = serviceAgence.update(pAgence);
		
		assertTrue(pAgenceTest != null);
	}

	@Test
	@Ignore
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		Agence pAgence = serviceAgence.getById(1L);
		assertTrue(pAgence != null);
	}

	@Test
	@Ignore
	public void testGetChiffreAffaire() {
		
		double chiffreAffaire = serviceAgence.getChiffreAffaire(1L, 2016);
		
		assertTrue(chiffreAffaire > 0);
	}

	@Test
	public void testGetVoituresDisponibles() {

		List<Voiture> listeVoit = serviceAgence.getVoituresDisponibles(1L, Utilitaire.stringToDate("02/02/2016"), Utilitaire.stringToDate("05/02/2016"));
		
		assertTrue(listeVoit.size() == 1);
	}

	@Test
	@Ignore
	public void testGetListeReservations() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetListeVoituresRetour() {
		fail("Not yet implemented");
	}

}
