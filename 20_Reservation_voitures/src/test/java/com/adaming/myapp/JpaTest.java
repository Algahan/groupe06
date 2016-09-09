package com.adaming.myapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaTest {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context;
		
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}

}
