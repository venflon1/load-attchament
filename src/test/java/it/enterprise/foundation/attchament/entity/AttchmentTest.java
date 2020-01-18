package it.enterprise.foundation.attchament.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.enterprise.foundation.attchment.entity.Attchment;
import it.enterprise.foundation.attchment.util.HibernateUtil;

public class AttchmentTest {
	private Logger log = LoggerFactory.getLogger(AttchmentTest.class);
	private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

	public Long create(Attchment atch) {
		log.info("class " + AttchmentTest.class.getSimpleName() + "- method create(Attchment atch) - START");
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		Long retValue = null;

		try {
			trx = session.beginTransaction();

			Long idEntity = ((Long) session.save(atch)).longValue();

			trx.commit();
			retValue = Long.valueOf(idEntity);
		} catch (Exception ex) {
			log.info("class " + AttchmentTest.class.getSimpleName()
					+ "- error in method create(Attchment atch) on transcation commit");
			retValue = Long.valueOf(-1L);
			try {
				trx.rollback();
			} catch (Exception e) {
				log.info("class " + AttchmentTest.class.getSimpleName()
						+ "- error in method create(Attchment atch) on transcation rollback");
				log.info(e.getMessage());
				e.printStackTrace();
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					log.info("class " + AttchmentTest.class.getSimpleName()
							+ "- errro in method create(Attchment atch) on session close");
					e.printStackTrace();
				}
			}

		}

		log.info("class " + AttchmentTest.class.getSimpleName() + "- method create(Attchment atch) - END");
		return retValue;
	}

	public Attchment getEntityForTest() {
		Attchment atch = new Attchment();
		atch.setContent("kjjksdbjkadsbvlasbvjkbvkjfbvjasbk");
		return atch;
	}
}
