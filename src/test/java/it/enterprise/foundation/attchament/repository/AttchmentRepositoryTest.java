package it.enterprise.foundation.attchament.repository;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import it.enterprise.foundation.attchament.entity.UserTest;
import it.enterprise.foundation.attchment.entity.Attchment;
import it.enterprise.foundation.attchment.entity.User;
import it.enterprise.foundation.attchment.repository.AttchmentRepository;
import it.enterprise.foundation.attchment.repository.UserRepository;

public class AttchmentRepositoryTest {
	private static Logger log = Logger.getLogger(UserTest.class);
	private static AttchmentRepository attchmentRepository = null;
	private static UserRepository userRepository = null;

	@BeforeClass
	public static void init() {
		log.info("class " + AttchmentRepositoryTest.class.getSimpleName() + "- method init() - START");
		attchmentRepository = new AttchmentRepository();
		userRepository = new UserRepository();
		log.info("class " + AttchmentRepositoryTest.class.getSimpleName() + "- method init() - END");
	}

	@Test
	public void testfindByIdOK() {
		log.info("class " + AttchmentRepositoryTest.class.getSimpleName() + "- method testCreateOK() - START");
		Attchment atch = attchmentRepository.getEntityForTest();
		atch.setContent("jkdwfjkbfwkbkjsbjkadbjkdbljkasb");
		List<Attchment> list = new ArrayList<Attchment>();
		list.add(atch);
		User user = userRepository.getEntityForTest();
 		user.setListAttchments(list);
 		userRepository.create(user);
 		Attchment atchmRetrieve = attchmentRepository.findById(1L);
 		assertNotNull(atchmRetrieve);
		log.info("class " + AttchmentRepositoryTest.class.getSimpleName() + "- method testCreateOK() - END");
	}
}
