package com.adaming.myapp.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.myapp.bo.Agence;
import com.adaming.myapp.service.IAgenceService;

@RestController
public class AgenceRest {
	
	@Inject
	private IAgenceService serviceAgence;
	
	@RequestMapping(value="/getAllAgences", method=RequestMethod.GET)
	public List<Agence> getAllAgences(){
		
		return serviceAgence.getAll();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Agence addAgence(@RequestBody Agence agence) {
		
		return serviceAgence.add(agence);
	}
	
	@RequestMapping(value="/getAgence/{agenceId}", method=RequestMethod.GET)
	public Agence getByIdAgence(@PathVariable long agenceId) {
		
		return serviceAgence.getById(agenceId);
	}


}
