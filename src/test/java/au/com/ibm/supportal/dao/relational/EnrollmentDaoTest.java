package au.com.ibm.supportal.dao.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import au.com.ibm.supportal.dao.Dao;
import au.com.ibm.supportal.dao.IEnrollmentDao;
import au.com.ibm.supportal.dao.ITrainingEventDao;
import au.com.ibm.supportal.dao.IUserDao;
import au.com.ibm.supportal.dao.RelationalTests;
import au.com.ibm.supportal.model.relational.AppUser;
import au.com.ibm.supportal.model.relational.Enrollment;
import au.com.ibm.supportal.model.relational.Lab;
import au.com.ibm.supportal.model.relational.TrainingEvent;
import au.com.ibm.supportal.model.relational.TrainingEventLab;

public class EnrollmentDaoTest extends RelationalTests {

	static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EnrollmentDaoTest.class);
	
	@Inject
	@Dao
	IEnrollmentDao dao;
	
	@Inject
	@Dao
	ITrainingEventDao trainingEventDao;
	
	@Inject
	@Dao
	IUserDao userDao;

	TrainingEvent trainingEvent;
	
	AppUser appUser;

	@Before
	public void setUp() {
		String id = "12345690";
		
		TrainingEvent event = new TrainingEvent();
		
		event.setStartDate(new Date());
		event.setEndDate(new Date());
		event.setId(id);
		
		List<TrainingEventLab> labs = new ArrayList<>();
		TrainingEventLab lab;
		for(int i=1; i < 10; i++) {
			lab = new TrainingEventLab();
			
			lab.setNumber(i);
			lab.setDescription("Lab " + i);
			labs.add(lab);
		}
		
		event.setLabs(labs);
		
		trainingEvent = trainingEventDao.saveAndFlush(event);
		
		AppUser user = new AppUser();
		user.setLogin("edhoi@au1.ibm.com");
		user.setPassword("welcome1");
		user.setRoles("TRAINER, TRAINEE, ADMIN");
		
		appUser = userDao.saveAndFlush(user);
	}
	
	@Test
	public void test() {
		String id = "12345690";
		
		Enrollment enrollment = new Enrollment();
		
		enrollment.setAppUser(appUser);
		enrollment.setTrainingEvent(trainingEvent);
		
		List<Lab> labs = new ArrayList<>();
		Lab lab;
		for(int i=1; i < 10; i++) {
			lab = new Lab(i, false);
			labs.add(lab);
		}
		
		enrollment.setLabs(labs);
		
		enrollment = dao.saveAndFlush(enrollment);
		
		LOGGER.info("\n" + enrollment.toString() + "\n");		

		Enrollment savedEnrollment = dao.findOne(enrollment.getId());
		
		assertNotNull(savedEnrollment);
		assertNotNull(savedEnrollment.getLabs());
		assertEquals(9, savedEnrollment.getLabs().size());
		LOGGER.info("\n" + savedEnrollment.toString() + "\n");		
	}
	
	@Test
	public void testEnrolling() {
	
		Enrollment enrollment = trainingEventDao.enroll(appUser, trainingEvent);
		assertEquals(trainingEvent.getLabs().size(), enrollment.getLabs().size());

		LOGGER.info("\n" + enrollment.toString() + "\n");		
	}

}
