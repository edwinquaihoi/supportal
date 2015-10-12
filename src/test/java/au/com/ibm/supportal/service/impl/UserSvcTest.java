package au.com.ibm.supportal.service.impl;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import au.com.ibm.supportal.model.relational.AppUser;
import au.com.ibm.supportal.service.IUserSvc;
import au.com.ibm.supportal.service.ServiceTests;

public class UserSvcTest extends ServiceTests {

	@EJB(name="UserSvcLocal")
	private IUserSvc userSvc;

	//@Test
	public void testCreate() {

		assertNotNull(userSvc);
		
		AppUser u = new AppUser();
		u.setLogin("sanket");
		u.setPassword("passw0rd");

		AppUser savedAcct = userSvc.update(u);
		
		assertNotNull(savedAcct);

	}

	@Test
	public void test() {}
}
