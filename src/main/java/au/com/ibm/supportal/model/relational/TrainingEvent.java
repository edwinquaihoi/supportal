package au.com.ibm.supportal.model.relational;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import au.com.ibm.supportal.scaffold.AbstractMasterEntity;

@Entity
public class TrainingEvent extends AbstractMasterEntity<String> {

	private static final long serialVersionUID = 3282493435258931916L;

	@Id
	private String id;
	
	@Temporal(TemporalType.TIME)
	private Date startDate;
	
	@Temporal(TemporalType.TIME)
	private Date endDate;

	@Version
	private int version;
	
	@ElementCollection
	private List<TrainingEventLab> labs;
	
	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public List<TrainingEventLab> getLabs() {
		return labs;
	}
	
	public void setLabs(List<TrainingEventLab> labs) {
		this.labs = labs;
	}
}
