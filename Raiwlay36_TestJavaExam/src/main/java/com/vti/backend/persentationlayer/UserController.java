package com.vti.backend.persentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class UserController {
	private IUserService iUserService;

	public UserController() throws FileNotFoundException, IOException {
		iUserService = new UserService();
	}

	public List<Employee> getEmployeeByProjectId(int projectId) throws SQLException, ClassNotFoundException {
		return iUserService.getEmployeeByProjectId(projectId);
	}

	public List<Manager> getManagerByProjectId(int projectId) throws SQLException, ClassNotFoundException {
		return iUserService.getManagerByProjectId(projectId);
	}
	
	public List<Manager> getManager() throws SQLException, ClassNotFoundException{
		return iUserService.getManager();
	}
	
	public User login(String email, String password) throws Exception {
		return iUserService.login(email, password);
	}
}
