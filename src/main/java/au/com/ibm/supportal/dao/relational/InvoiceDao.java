package au.com.ibm.supportal.dao.relational;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import au.com.ibm.supportal.dao.Dao;
import au.com.ibm.supportal.dao.IInvoiceDao;
import au.com.ibm.supportal.dao.relational.repository.InvoiceRepository;
import au.com.ibm.supportal.model.relational.Invoice;


@Dao
public class InvoiceDao extends AbstractDao<Invoice, String, InvoiceRepository> implements IInvoiceDao {

	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(InvoiceRepository.class));
	}



}
