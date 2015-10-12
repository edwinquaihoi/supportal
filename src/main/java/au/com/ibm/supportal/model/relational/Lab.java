package au.com.ibm.supportal.model.relational;

import javax.persistence.Embeddable;

@Embeddable
public class Lab {

	private int number;
	
	private boolean complete;
	
	public Lab() {
		// TODO Auto-generated constructor stub
	}
	
	public Lab(int number, boolean complete) {
		super();
		this.number = number;
		this.complete = complete;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}	
}
