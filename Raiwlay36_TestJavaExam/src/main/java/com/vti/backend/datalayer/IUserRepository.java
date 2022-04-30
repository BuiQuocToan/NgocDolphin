package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;

public interface IUserRepository {
	public List<Employee> getEmployeeByProjectId(int projectId) throws SQLException, ClassNotFoundException;
	
	public List<Manager> getManagerByProjectId(int projectId) throws SQLException, ClassNotFoundException;
	
	public List<Manager> getManager() throws SQLException, ClassNotFoundException;
	
	public User login(String email, String password) throws Exception;

}
