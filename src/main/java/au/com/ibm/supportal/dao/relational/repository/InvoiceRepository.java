package au.com.ibm.supportal.dao.relational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import au.com.ibm.supportal.model.relational.Invoice;

@NoRepositoryBean
@Repo
public interface InvoiceRepository extends JpaRepository<Invoice, String>{

}
