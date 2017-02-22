package com.openshift.test.util;

import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static final SessionFactory sessionFactory;

	static {
		try {
			System.out.println("Inside static initializer block");
			// Create the SessionFactory from hibernate.cfg.xml
			File configFile = new File();
			Configuration config = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	public static Session currentSession() throws HibernateException {
		Session s = (Session) session.get();
		// Open a new Session, if this thread has none yet
		if (s == null) {
			System.out.println("opening new session");
			s = sessionFactory.openSession();
			// Store it in the ThreadLocal variable
			session.set(s);
		} else {
			s.close();
			s = sessionFactory.openSession();
		}
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		if (s != null)
			s.close();
		session.set(null);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
