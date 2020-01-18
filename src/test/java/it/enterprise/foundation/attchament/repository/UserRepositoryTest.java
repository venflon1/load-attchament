package it.enterprise.foundation.attchament.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

public class UserRepositoryTest {
	private static Logger log = Logger.getLogger(UserTest.class);
	private static UserRepository userRepository = null;
	private static AttchmentRepository attchmentRepository = null;

	@BeforeClass
	public static void init() {
		log.info("class " + UserRepositoryTest.class.getSimpleName() + "- method init() - START");
		userRepository = new UserRepository();
		attchmentRepository = new AttchmentRepository();
		log.info("class " + UserRepositoryTest.class.getSimpleName() + "- method init() - END");
	}

	@Test
	public void testCreateOK() {
		log.info("class " + UserRepositoryTest.class.getSimpleName() + "- method testCreateOK() - START");
		Attchment atch1 = attchmentRepository.getEntityForTest();
		atch1.setContent("kfnlk-lnglenglnlkfenlw");

		Attchment atch2 = attchmentRepository.getEntityForTest();
		atch2.setContent("òojpojlnlnmebfkwweljbfjkwe");

		User user = userRepository.getEntityForTest();

		List<Attchment> list = new ArrayList<Attchment>();
		list.add(atch1);
		list.add(atch2);
		user.setListAttchments(list);
		Long retValue = userRepository.create(user);
		assertTrue(retValue != -1);
		log.info("class " + UserRepositoryTest.class.getSimpleName() + "- method testCreateOK() - END");
	}

	@Test
	public void testFindById() {
		log.info("class " + UserRepositoryTest.class.getSimpleName() + "- method testFindById()  - START");
		Attchment atch1 = attchmentRepository.getEntityForTest();
		atch1.setContent("kfnlk-lnglenglnlkfenlw");

		Attchment atch2 = attchmentRepository.getEntityForTest();
		atch2.setContent("òojpojlnlnmebfkwweljbfjkwe");

		User user = userRepository.getEntityForTest();

		List<Attchment> list = new ArrayList<Attchment>();
		list.add(atch1);
		list.add(atch2);
		user.setListAttchments(list);
		Long retValue = userRepository.create(user);
		User usr = userRepository.findById(retValue);
		assertNotNull(usr);
		System.out.println(usr);
		log.info("class " + UserRepositoryTest.class.getSimpleName() + "- method testFindById()  - END");
	}
}
