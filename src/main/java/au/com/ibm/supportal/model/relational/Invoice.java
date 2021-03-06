package au.com.ibm.supportal.model.relational;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import au.com.ibm.supportal.scaffold.AbstractMasterEntity;

@Entity
public class Invoice extends AbstractMasterEntity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5548325782346547585L;

	public static final String BLOCKED = "Blocked";
	public static final String REJECTED = "Rejected";
	public static final String PAID = "Paid";
	public static final String FREE_FOR_PAYMENT = "Free for payment";
	public static final String IN_PROGRESS = "In progress";
	
	public static final String TYPE_CREDIT = "Credit";
	public static final String TYPE_INVOICE = "Invoice";
		
	
	@Id
	String invoiceNo;

	@Version
	private int version;
	
	String status;
	
	String type;
	
	String reason;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date paymentBaseline;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date plannedPayment;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date dueDate;
	
	String remittanceNo;
	
	String internalInvoiceNo;
	
	String PO;
	
	double value;
	
	String currency;
	
	String email;
	
	@Override
	public String getSearchResultInfo() {
		return null;
	}

	@Override
	public String getId() {
		return getInvoiceNo();
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getPaymentBaseline() {
		return paymentBaseline;
	}

	public void setPaymentBaseline(Date paymentBaseline) {
		this.paymentBaseline = paymentBaseline;
	}

	public Date getPlannedPayment() {
		return plannedPayment;
	}

	public void setPlannedPayment(Date plannedPayment) {
		this.plannedPayment = plannedPayment;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getRemittanceNo() {
		return remittanceNo;
	}

	public void setRemittanceNo(String remittanceNo) {
		this.remittanceNo = remittanceNo;
	}

	public String getInternalInvoiceNo() {
		return internalInvoiceNo;
	}

	public void setInternalInvoiceNo(String internalInvoiceNo) {
		this.internalInvoiceNo = internalInvoiceNo;
	}

	public String getPO() {
		return PO;
	}

	public void setPO(String pO) {
		PO = pO;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFormattedPaymentBaseline() {
		String result = null;
		if(getPaymentBaseline() != null)
			result = new SimpleDateFormat("dd-MMM-yy").format(getPaymentBaseline());
		return result;
	}
	
	public String getFormattedDueDate() {
		String result = null;
		if(getDueDate() != null) result = new SimpleDateFormat("dd-MMM-yy").format(getDueDate());
		return result;
	}
	
	public String getFormattedPlannedPayment() {
		String result = null;
		if(getPlannedPayment() != null) result = new SimpleDateFormat("dd-MMM-yy").format(getPlannedPayment());
		return result;
	}

}
