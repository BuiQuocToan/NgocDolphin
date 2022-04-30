package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class UserService implements IUserService{
	private IUserRepository iUserRepository;

	public UserService() throws FileNotFoundException, IOException {
		iUserRepository = new UserRepository();
	}

	public List<Employee> getEmployeeByProjectId(int projectId) throws SQLException, ClassNotFoundException {
		return iUserRepository.getEmployeeByProjectId(projectId);
	}

	public List<Manager> getManagerByProjectId(int projectId) throws SQLException, ClassNotFoundException {
		return iUserRepository.getManagerByProjectId(projectId);
	}
	
	public List<Manager> getManager() throws SQLException, ClassNotFoundException{
		return iUserRepository.getManager();
	}

	@Override
	public User login(String email, String password) throws Exception {
		return iUserRepository.login(email, password);
	}
}
