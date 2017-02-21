package com.openshift.test.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateListener implements ServletContextListener  {
	 public void contextInitialized(ServletContextEvent event) {  
		 	System.out.println("**************context intialized");
	        HibernateUtil.getSessionFactory(); // Just call the static initializer of that class      
	    }  
	  
	    public void contextDestroyed(ServletContextEvent event) {  
	    	System.out.println("**************context closed");
	        HibernateUtil.getSessionFactory().close(); // Free all resources  
	    }  

}
