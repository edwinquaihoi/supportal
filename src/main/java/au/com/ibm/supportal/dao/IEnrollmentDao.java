package au.com.ibm.supportal.dao;

import org.springframework.data.repository.NoRepositoryBean;

import au.com.ibm.supportal.dao.relational.repository.EnrollmentRepository;
import au.com.ibm.supportal.model.relational.AppUser;
import au.com.ibm.supportal.model.relational.Enrollment;
import au.com.ibm.supportal.model.relational.EnrollmentPk;
import au.com.ibm.supportal.model.relational.TrainingEvent;
import au.com.ibm.supportal.scaffold.IDao;

@NoRepositoryBean
public interface IEnrollmentDao extends IDao<Enrollment, EnrollmentPk, EnrollmentRepository> , EnrollmentRepository {

}
