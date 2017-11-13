package com.spring.batch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	 
	    @SuppressWarnings("unused")
		public static void main(String[] args) {
	          
	        ApplicationContext context = new ClassPathXmlApplicationContext("quartz-context.xml");
	      
	    }

}
