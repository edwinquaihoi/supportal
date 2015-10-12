package au.com.ibm.supportal.dao.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;

import au.com.ibm.supportal.dao.Dao;
import au.com.ibm.supportal.dao.ITrainingEventDao;
import au.com.ibm.supportal.dao.RelationalTests;
import au.com.ibm.supportal.model.relational.TrainingEvent;
import au.com.ibm.supportal.model.relational.TrainingEventLab;

public class TrainingEventDaoTest extends RelationalTests {

	static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TrainingEventDaoTest.class);
	
	@Inject
	@Dao
	ITrainingEventDao dao;
	
	@Test
	public void test() {
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
		
		dao.saveAndFlush(event);
		
		TrainingEvent savedTrainingEvent = dao.findOne(id);
		
		assertNotNull(savedTrainingEvent);
		assertNotNull(savedTrainingEvent.getLabs());
		assertEquals(9, savedTrainingEvent.getLabs().size());
		System.out.println("");
		LOGGER.info(savedTrainingEvent.toString());
		System.out.println("");
		
		TrainingEventLab newLab = new TrainingEventLab();
		newLab.setNumber(10);
		newLab.setDescription("Lab 10");
				
		savedTrainingEvent = dao.addLab(savedTrainingEvent, newLab);

		assertEquals(10, savedTrainingEvent.getLabs().size());
		System.out.println("");
		LOGGER.info(savedTrainingEvent.toString());
		System.out.println("");

		savedTrainingEvent = dao.deleteLab(savedTrainingEvent, newLab);

		assertEquals(9, savedTrainingEvent.getLabs().size());
		System.out.println("");
		LOGGER.info(savedTrainingEvent.toString());
		System.out.println("");
	}

}
