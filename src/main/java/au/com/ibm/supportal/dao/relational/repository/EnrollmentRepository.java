package au.com.ibm.supportal.dao.relational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import au.com.ibm.supportal.model.relational.Enrollment;
import au.com.ibm.supportal.model.relational.EnrollmentPk;

@NoRepositoryBean
@Repo
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPk>{

}
