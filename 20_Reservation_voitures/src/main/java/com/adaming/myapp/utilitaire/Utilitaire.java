package com.adaming.myapp.utilitaire;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utilitaire {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * transforme string au format dd/MM/yyyy java.util.Date
	 * return null si format incorrecte
	 * @param dateFormattee
	 * @return
	 */
	public static Date stringToDate(String dateFormattee) {
		
		try {
			
			return formatter.parse(dateFormattee);
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static long NbJoursEntreDates(Date dateDebut, Date dateFin) {
		
		long diff = dateFin.getTime() -  dateDebut.getTime();				
		long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
		return days;
	}

}
