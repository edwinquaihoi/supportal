package au.com.ibm.supportal.dao.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import au.com.ibm.supportal.dao.Dao;
import au.com.ibm.supportal.dao.IInvoiceDao;
import au.com.ibm.supportal.dao.RelationalTests;
import au.com.ibm.supportal.model.relational.Invoice;

public class InvoiceDaoTest extends RelationalTests {

	@Inject
	@Dao
	IInvoiceDao dao;
	
	@Test
	public void test() {
		Invoice invoice = new Invoice();
		invoice.setInvoiceNo("1234");
		invoice.setPaymentBaseline(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		dao.save(invoice);
		
		Invoice u2 = dao.findOne("1234");
		
		assertNotNull(u2);
		assertEquals("1234", u2.getInvoiceNo());
		assertNotNull(u2.getPaymentBaseline());
		System.out.println(u2.getPaymentBaseline());
	}
	
	
}
