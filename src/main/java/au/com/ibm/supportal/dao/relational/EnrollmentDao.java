package au.com.ibm.supportal.dao.relational;

import javax.annotation.PostConstruct;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import au.com.ibm.supportal.dao.Dao;
import au.com.ibm.supportal.dao.IEnrollmentDao;
import au.com.ibm.supportal.dao.relational.repository.EnrollmentRepository;
import au.com.ibm.supportal.model.relational.AppUser;
import au.com.ibm.supportal.model.relational.Enrollment;
import au.com.ibm.supportal.model.relational.EnrollmentPk;
import au.com.ibm.supportal.model.relational.TrainingEvent;


@Dao
public class EnrollmentDao extends AbstractDao<Enrollment, EnrollmentPk, EnrollmentRepository> implements IEnrollmentDao {

	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(EnrollmentRepository.class));
	}
}
