package it.enterprise.foundation.attchment.repository;


import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.enterprise.foundation.attchment.entity.User;
import it.enterprise.foundation.attchment.util.HibernateUtil;
public class UserRepository {

	private Logger log = LoggerFactory.getLogger(UserRepository.class);
	private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	
	public Long create(User user) {
		log.info("class " + UserRepository.class.getSimpleName() + "- method create(User user) - START");
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		Long retValue = null;
		
		try {
			 trx = session.beginTransaction();
			
			 Long idEntity = ((Long) session.save(user)).longValue();
			
		 	 trx.commit();
		 	 retValue = Long.valueOf(idEntity);
		} catch (Exception ex) {
			log.info("class " + UserRepository.class.getSimpleName() + "- error in method create(User user) on transcation commit");
			retValue = Long.valueOf(-1L);
			try {
				trx.rollback();				
			} catch (Exception e) {
				log.info("class " + UserRepository.class.getSimpleName() + "- error in method create(User user) on transcation rollback");
				log.info(e.getMessage());
				e.printStackTrace();
			}
		} finally {
			if(session != null) {
				try {
					session.close();
				} catch (Exception e) {
					log.info("class " + UserRepository.class.getSimpleName() + "- errro in method create(User user) on session close");
					e.printStackTrace();
				}
			}
				
		}
		
		log.info("class " + UserRepository.class.getSimpleName() + "- method create(User user) - END");
		return retValue;
	}
	
	public User findById(Long id) {
		log.info("class " + UserRepository.class.getSimpleName() + "- method findById(Long id) - START");
		Session session = sessionFactory.openSession();
		Transaction trx = null;
		User retValue = null;
		
		try {
			 trx = session.beginTransaction();
			
			 retValue =  session.find(User.class, id);
			
		 	 trx.commit();
		} catch (Exception ex) {
			log.info("class " + UserRepository.class.getSimpleName() + "- error in method findById(Long id) on transcation commit");
			try {
				trx.rollback();				
			} catch (Exception e) {
				log.info("class " + UserRepository.class.getSimpleName() + "- error in method findById(Long id) on transcation rollback");
				log.info(e.getMessage());
				e.printStackTrace();
			}
		} finally {
			if(session != null) {
				try {
					session.close();
				} catch (Exception e) {
					log.info("class " + UserRepository.class.getSimpleName() + "- errro in method findById(Long id) on session close");
					e.printStackTrace();
				}
			}
				
		}
		
		log.info("class " + UserRepository.class.getSimpleName() + "- method findById(Long id) - END");
		return retValue;
	}
	
	public User getEntityForTest() {
		User user = new User();
		user.setCode("MTARRT93H11E573Z");
		user.setName("Roberto");
		user.setSurname("Amato");
		user.setBornDate(LocalDate.now());
		user.setEmail("robertoxx93@libero.it");
		return user;
	}
}
