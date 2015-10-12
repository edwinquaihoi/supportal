package au.com.ibm.supportal.dao.relational;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import au.com.ibm.supportal.dao.Dao;
import au.com.ibm.supportal.dao.IEnrollmentDao;
import au.com.ibm.supportal.dao.ITrainingEventDao;
import au.com.ibm.supportal.dao.relational.repository.TrainingEventRepository;
import au.com.ibm.supportal.model.relational.AppUser;
import au.com.ibm.supportal.model.relational.Enrollment;
import au.com.ibm.supportal.model.relational.Lab;
import au.com.ibm.supportal.model.relational.TrainingEvent;
import au.com.ibm.supportal.model.relational.TrainingEventLab;


@Dao
public class TrainingEventDao extends AbstractDao<TrainingEvent, String, TrainingEventRepository> implements ITrainingEventDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrainingEventDao.class);
	
	@Dao
	@Inject
	private IEnrollmentDao enrollmentDao;
	
	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(TrainingEventRepository.class));
	}
	
	public IEnrollmentDao getEnrollmentDao() {
		return enrollmentDao;
	}

	public void setEnrollmentDao(IEnrollmentDao enrollmentDao) {
		this.enrollmentDao = enrollmentDao;
	}

	@Override
	public TrainingEvent addLab(TrainingEvent trainingEvent, TrainingEventLab lab) {
		trainingEvent.getLabs().add(lab);		
		return getRepository().saveAndFlush(trainingEvent);
	}

	@Override
	public TrainingEvent deleteLab(TrainingEvent trainingEvent, TrainingEventLab lab) {
		
		LOGGER.info("event=deleteLab, success=" + trainingEvent.getLabs().remove(lab));
		
		return getRepository().saveAndFlush(trainingEvent);
	}

	@Override
	public Enrollment enroll(AppUser user, TrainingEvent event) {
		
		Enrollment enrollment = new Enrollment();
		enrollment.setAppUser(user);
		enrollment.setTrainingEvent(event);
		
		List<Lab> labs = new ArrayList<>();
		
		for(TrainingEventLab lab : event.getLabs()) {
			labs.add(new Lab(lab.getNumber(), false));
		}
		
		enrollment.setLabs(labs);
		
		return getEnrollmentDao().saveAndFlush(enrollment);
	}
}
