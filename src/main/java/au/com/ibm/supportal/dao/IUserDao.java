package au.com.ibm.supportal.dao;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import au.com.ibm.supportal.dao.relational.repository.UserRepository;
import au.com.ibm.supportal.model.relational.AppUser;
import au.com.ibm.supportal.scaffold.IDao;

@NoRepositoryBean
public interface IUserDao extends IDao<AppUser, String, UserRepository> , UserRepository {

	/**
	 * Search user by entered substring
	 * @param genericSearchString
	 * @return users where username match to the search string
	 */
	List<AppUser> findByLoginLike(String genericSearchString);
	

}
