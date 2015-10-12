package au.com.ibm.supportal.web.forms.ui;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import au.com.ibm.supportal.model.relational.TrainingEvent;
import au.com.ibm.supportal.model.relational.TrainingEventLab;
import au.com.ibm.supportal.scaffold.AbstractMaintenanceForm;
import au.com.ibm.supportal.scaffold.IService;
import au.com.ibm.supportal.service.ITrainingEventSvc;

@ManagedBean
public class TrainingEventForm extends AbstractMaintenanceForm<String, TrainingEvent> {

	private static final long serialVersionUID = 3996403834970413650L;

	@EJB
	private ITrainingEventSvc trainingEventSvc;
	
	@Override
	public TrainingEvent getNewOne() {
		TrainingEvent trainingEvent = new TrainingEvent();
		trainingEvent.setLabs(new ArrayList<>());
		
		// TODO remove the next fews lines
		TrainingEventLab lab = new TrainingEventLab();
		lab.setDescription("Test");
		lab.setNumber(1);
		
		trainingEvent.getLabs().add(lab);
		
		return trainingEvent;
	}

	@Override
	public List<TrainingEvent> getDefaultSearchResults() {
		return new ArrayList<>();
	}

	@Override
	public String getEntityBusinessName() {
		return "Training Event";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public IService getService() {
		return getTrainingEventSvc();
	}
	
	public ITrainingEventSvc getTrainingEventSvc() {
		return trainingEventSvc;
	}
	
	public void setTrainingEventSvc(ITrainingEventSvc trainingEventSvc) {
		this.trainingEventSvc = trainingEventSvc;
	}
}
