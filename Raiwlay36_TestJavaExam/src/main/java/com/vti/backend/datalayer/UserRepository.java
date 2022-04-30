package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.properties.JdbcUtils;

public class UserRepository implements IUserRepository {
	private JdbcUtils jdbcUtils;

	public UserRepository() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	// Nhập vào projectId và in ra các employee của project đó
	public List<Employee> getEmployeeByProjectId(int projectId) throws SQLException, ClassNotFoundException {
		List<Employee> employees = new ArrayList<>();
		try {
			String sql = "SELECT * FROM testjavaexam.user WHERE Role = 'Employee' AND ProjectId = ?";
			PreparedStatement statement = jdbcUtils.Connect().prepareStatement(sql);
			statement.setInt(1, projectId);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int ID = resultSet.getInt("ID");
				String Fullname = resultSet.getString("FullName");
				String Email = resultSet.getString("Email");
				String PassWord = resultSet.getString("Password");
				int ProjectId = resultSet.getInt("ProjectId");
				String ProSkill = resultSet.getString("ProSkill");
				Role role;
				role = Role.EMPLOYEE;
				Employee employee = new Employee(ID, Fullname, Email, PassWord, ProjectId, ProSkill, role);
				employees.add(employee);
			}
			return employees;
		} finally {
			jdbcUtils.disconnect();
		}
	}

	// Nhập vào projectId và in ra các manager của project đó
	public List<Manager> getManagerByProjectId(int projectId) throws SQLException, ClassNotFoundException {
		List<Manager> managers = new ArrayList<>();
		try {
			String sql = "SELECT * FROM testjavaexam.user WHERE Role = 'Manager' AND ProjectId = ?";
			PreparedStatement statement = jdbcUtils.Connect().prepareStatement(sql);
			statement.setInt(1, projectId);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int ID = resultSet.getInt("ID");
				String Fullname = resultSet.getString("FullName");
				String Email = resultSet.getString("Email");
				String PassWord = resultSet.getString("Password");
				int ProjectId = resultSet.getInt("ProjectId");
				int expInYear = resultSet.getInt("expInYear");
				Role role;
				role = Role.MANAGER;
				Manager manager = new Manager(ID, Fullname, Email, PassWord, ProjectId, expInYear, role);
				managers.add(manager);
			}
			return managers;
		} finally {
			jdbcUtils.disconnect();
		}
	}

	// In ra tất cả các Manager
	public List<Manager> getManager() throws SQLException, ClassNotFoundException {
		List<Manager> managers = new ArrayList<>();
		try {
			String sql = "SELECT * FROM testjavaexam.user WHERE Role = 'Manager'";
			Statement statement = jdbcUtils.Connect().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int ID = resultSet.getInt("ID");
				String Fullname = resultSet.getString("FullName");
				String Email = resultSet.getString("Email");
				String PassWord = resultSet.getString("Password");
				int ProjectId = resultSet.getInt("ProjectId");
				int expInYear = resultSet.getInt("expInYear");
				Role role;
				role = Role.MANAGER;
				Manager manager = new Manager(ID, Fullname, Email, PassWord, ProjectId, expInYear, role);
				managers.add(manager);
			}
			return managers;
		} finally {
			jdbcUtils.disconnect();
		}
	}

	// login
	public User login(String email, String password) throws Exception {
		try {
			String sql = "SELECT * FROM testjavaexam.user WHERE Email = ? AND `Password` = ?";
			PreparedStatement statement = jdbcUtils.Connect().prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int ID = resultSet.getInt("ID");
				String Fullname = resultSet.getString("FullName");
				String Email = resultSet.getString("Email");
				String PassWord = resultSet.getString("Password");
				int ProjectId = resultSet.getInt("ProjectId");
				int expInYear = resultSet.getInt("expInYear");
				String ProSkill = resultSet.getString("ProSkill");
				if (resultSet.getString("Role").equals("Manager")) {
					User manager = new Manager(ID, Fullname, Email, PassWord, ProjectId, expInYear, Role.MANAGER);
					return manager;
				} else {
					User employee = new Employee(ID, Fullname, Email, PassWord, ProjectId, ProSkill, Role.EMPLOYEE);
					return employee;
				}
			} else {
				throw new Exception("Email hoặc mật khẩu sai!");
			}
		} finally {
			jdbcUtils.disconnect();
		}
	}

}
