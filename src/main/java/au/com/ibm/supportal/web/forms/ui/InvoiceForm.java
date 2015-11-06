/**
 * 
 */
package au.com.ibm.supportal.web.forms.ui;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import au.com.ibm.supportal.model.relational.Invoice;
import au.com.ibm.supportal.scaffold.AbstractMaintenanceForm;
import au.com.ibm.supportal.scaffold.IService;
import au.com.ibm.supportal.service.IInvoiceSvc;
import au.com.ibm.supportal.service.IUserSvc;

/**
 * @author sanketsw
 *
 */
@ManagedBean
public class InvoiceForm extends AbstractMaintenanceForm<String, Invoice> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 527811944460879541L;
	
	@EJB
	private IInvoiceSvc invoiceSvc;
	
	private List<Invoice> filteredInvoices;
	
	/*--START of Getters and Setters-- */
	
	
	
	public IInvoiceSvc getInvoiceSvc() {
		return invoiceSvc;
	}

	public List<Invoice> getFilteredInvoices() {
		return filteredInvoices;
	}

	public void setFilteredInvoices(List<Invoice> filteredInvoices) {
		this.filteredInvoices = filteredInvoices;
	}
	
	/*--END of Getters and Setters-- */
	/*--START of default methods-- */
	
	@Override
	public Invoice getNewOne() {
		return new Invoice();
	}

	@Override
	public List<Invoice> getDefaultSearchResults() {
		return invoiceSvc.getAll();
	}

	@Override
	public String getEntityBusinessName() {
		return "Invoice";
	}

	@Override
	public IService getService() {
		return invoiceSvc;
	}
	
	
	
	/*--END of Default methods-- */

}
