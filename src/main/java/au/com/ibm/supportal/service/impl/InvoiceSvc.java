package au.com.ibm.supportal.service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import au.com.ibm.supportal.dao.Dao;
import au.com.ibm.supportal.dao.IInvoiceDao;
import au.com.ibm.supportal.model.relational.Invoice;
import au.com.ibm.supportal.service.IInvoiceSvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Path("/invoice")
public class InvoiceSvc implements IInvoiceSvc {

	@Inject
	@Dao
	private IInvoiceDao dao;

	public IInvoiceDao getDao() {
		return dao;
	}

	public void setDao(IInvoiceDao dao) {
		this.dao = dao;
	}

	@Override
	public Invoice getById(String pId) {
		return getDao().findOne(pId);
	}
	
	@Override
	public Invoice create(Invoice pEntity) {
		return getDao().save(pEntity);
	}
	
	@Override
	public Invoice update(Invoice pEntity) {
		return getDao().save(pEntity);
	}

	@Override
	public void delete(Invoice pEntity) {
		getDao().delete(pEntity);
	}
	
	@Override
	@GET
	@Path("/list")
	@Produces({ "application/json" })
	public List<Invoice> getAll() {
		return getDao().findAll();
	}
	
	@Override
	@POST
	@Path("/upload")
	@Produces({ "application/json" })
	@Consumes(MediaType.APPLICATION_JSON)
	public void uplaodInvoiceData(List<Invoice> invoiceList) {
		getDao().save(invoiceList);
		getDao().flush();
		System.out.println(getDao().findAll());
	}
}
