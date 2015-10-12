package au.com.ibm.supportal.dao.relational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import au.com.ibm.supportal.model.relational.AppUser;
import au.com.ibm.supportal.model.relational.TrainingEvent;

@NoRepositoryBean
@Repo
public interface TrainingEventRepository extends JpaRepository<TrainingEvent, String>{

}
