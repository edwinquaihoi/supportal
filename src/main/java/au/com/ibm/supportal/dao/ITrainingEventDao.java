package au.com.ibm.supportal.dao;

import org.springframework.data.repository.NoRepositoryBean;

import au.com.ibm.supportal.dao.relational.repository.TrainingEventRepository;
import au.com.ibm.supportal.model.relational.AppUser;
import au.com.ibm.supportal.model.relational.Enrollment;
import au.com.ibm.supportal.model.relational.TrainingEvent;
import au.com.ibm.supportal.model.relational.TrainingEventLab;
import au.com.ibm.supportal.scaffold.IDao;

@NoRepositoryBean
public interface ITrainingEventDao extends IDao<TrainingEvent, String, TrainingEventRepository> , TrainingEventRepository {
	
	TrainingEvent addLab(TrainingEvent trainingEvent, TrainingEventLab lab);
	TrainingEvent deleteLab(TrainingEvent trainingEvent, TrainingEventLab lab);
	Enrollment enroll(AppUser user, TrainingEvent event);

}
