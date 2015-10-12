package au.com.ibm.supportal.model.relational;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import au.com.ibm.supportal.scaffold.AbstractMasterEntity;

@Entity
@IdClass(EnrollmentPk.class)
public class Enrollment extends AbstractMasterEntity<EnrollmentPk> {

	private static final long serialVersionUID = 6424621088202255736L;

	@Id
	@ManyToOne
	private AppUser appUser;
	
	@Id
	@ManyToOne
	private TrainingEvent trainingEvent;
	
	@ElementCollection
	private List<Lab> labs;

	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnrollmentPk getId() {
		return new EnrollmentPk(getAppUser().getLogin(), getTrainingEvent().getId());
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public TrainingEvent getTrainingEvent() {
		return trainingEvent;
	}

	public void setTrainingEvent(TrainingEvent trainingEvent) {
		this.trainingEvent = trainingEvent;
	}
	
	public List<Lab> getLabs() {
		return labs;
	}
	
	public void setLabs(List<Lab> labs) {
		this.labs = labs;
	}
}
