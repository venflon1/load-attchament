package it.enterprise.foundation.attchment.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static HibernateUtil _instance = null;

	private SessionFactory sessionFactory = null;

	private HibernateUtil() {
		super();

		this.sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public static synchronized HibernateUtil getInstance() {
		if (HibernateUtil._instance == null)
			HibernateUtil._instance = new HibernateUtil();
		return HibernateUtil._instance;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public void close() {
		this.sessionFactory.close();
	}
}
