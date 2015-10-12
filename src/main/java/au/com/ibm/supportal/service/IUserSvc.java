package au.com.ibm.supportal.service;

import javax.ejb.Local;

import au.com.ibm.supportal.dao.IUserDao;
import au.com.ibm.supportal.dao.relational.repository.UserRepository;
import au.com.ibm.supportal.model.relational.AppUser;
import au.com.ibm.supportal.scaffold.IService;

@Local
public interface IUserSvc extends IService<AppUser, String, UserRepository, IUserDao> {

}
