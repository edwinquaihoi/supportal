package au.com.ibm.supportal.service.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import au.com.ibm.supportal.dao.Dao;
import au.com.ibm.supportal.dao.ITrainingEventDao;
import au.com.ibm.supportal.service.ITrainingEventSvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TrainingEventSvc implements ITrainingEventSvc {

	@Inject
	@Dao
	private ITrainingEventDao dao;

	public ITrainingEventDao getDao() {
		return dao;
	}

	public void setDao(ITrainingEventDao dao) {
		this.dao = dao;
	}
}
