package au.com.ibm.supportal.service;

import java.util.List;

import javax.ejb.Local;

import au.com.ibm.supportal.dao.IInvoiceDao;
import au.com.ibm.supportal.dao.relational.repository.InvoiceRepository;
import au.com.ibm.supportal.model.relational.Invoice;
import au.com.ibm.supportal.scaffold.IService;

@Local
public interface IInvoiceSvc extends IService<Invoice, String, InvoiceRepository, IInvoiceDao> {

	/**
	 * Upload invoice data using JSON format
	 * @param invoiceList
	 */
	void uplaodInvoiceData(List<Invoice> invoiceList);

}
