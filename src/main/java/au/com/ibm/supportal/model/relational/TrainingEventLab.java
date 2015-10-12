package au.com.ibm.supportal.model.relational;

import javax.persistence.Embeddable;
import javax.persistence.Version;

import org.apache.commons.lang.builder.EqualsBuilder;

@Embeddable
public class TrainingEventLab {

	private int number;
		
	private String description;
		
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

	@Override
	 public boolean equals(Object obj) {
		   if (obj == null) { return false; }
		   if (obj == this) { return true; }
		   if (obj.getClass() != getClass()) {
		     return false;
		   }
		   TrainingEventLab rhs = (TrainingEventLab) obj;
		   return new EqualsBuilder()
		                 .append(number, rhs.number)
		                 .append(description, rhs.description)
		                 .isEquals();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
