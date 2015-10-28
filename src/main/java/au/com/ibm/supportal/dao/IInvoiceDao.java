package au.com.ibm.supportal.dao;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import au.com.ibm.supportal.dao.relational.repository.InvoiceRepository;
import au.com.ibm.supportal.model.relational.Invoice;
import au.com.ibm.supportal.scaffold.IDao;

@NoRepositoryBean
public interface IInvoiceDao extends IDao<Invoice, String, InvoiceRepository> , InvoiceRepository {
	

}
