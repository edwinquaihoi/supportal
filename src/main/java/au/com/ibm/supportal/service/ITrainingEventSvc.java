package au.com.ibm.supportal.service;

import javax.ejb.Local;

import au.com.ibm.supportal.dao.ITrainingEventDao;
import au.com.ibm.supportal.dao.relational.repository.TrainingEventRepository;
import au.com.ibm.supportal.model.relational.TrainingEvent;
import au.com.ibm.supportal.scaffold.IService;

@Local
public interface ITrainingEventSvc extends IService<TrainingEvent, String, TrainingEventRepository, ITrainingEventDao> {

}
