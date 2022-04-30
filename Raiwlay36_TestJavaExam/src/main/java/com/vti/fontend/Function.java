package com.vti.fontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.persentationlayer.UserController;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;
import com.vti.utils.properties.ScannerUtils;

public class Function {
	private UserController userController;

	public Function() throws FileNotFoundException, IOException {
		userController = new UserController();
	}

	public void getEmployeeByProjectId() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào ProjectId: ");
		int projectId = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời nhập lại");

		List<Employee> employees = userController.getEmployeeByProjectId(projectId);
		if (employees.size() != 0) {
			System.out.printf("%-10s %-15s %-25s %-15s %-15s %-15s %-15s %-15s\n", "ID", "Fullname", "Email",
					"Password", "ProjectId", "ExpInYear", "ProSkill", "Role");
			for (Employee employee : employees) {
				System.out.printf("%-10s %-15s %-25s %-15s %-15s %-15s %-15s %-15s\n", employee.getId(),
						employee.getFullName(), employee.getEmail(), "******", employee.getProjectId(), "null",
						employee.getProSkill(), employee.getRole());
			}
			return;
		} else {
			System.err.println("Không tìm thấy Employee có projectId = " + projectId);
		}
	}

	public void getManagerByProjectId() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào ProjectId: ");
		int projectId = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời nhập lại");

		List<Manager> managers = userController.getManagerByProjectId(projectId);
		if (managers.size() != 0) {
			System.out.printf("%-10s %-15s %-25s %-15s %-15s %-15s %-15s %-15s\n", "ID", "Fullname", "Email",
					"Password", "ProjectId", "ExpInYear", "ProSkill", "Role");
			for (Manager manager : managers) {
				System.out.printf("%-10s %-15s %-25s %-15s %-15s %-15s %-15s %-15s\n", manager.getId(),
						manager.getFullName(), manager.getEmail(), "******", manager.getProjectId(),
						manager.getExpInYear(), "null", manager.getRole());
			}
			return;
		} else {
			System.err.println("Không tìm thấy Manager có projectId = " + projectId);
		}
	}

	public void getManager() throws ClassNotFoundException, SQLException {
		List<Manager> managers = userController.getManager();

		System.out.printf("%-10s %-15s %-25s %-15s %-15s %-15s %-15s %-15s\n", "ID", "Fullname", "Email", "Password",
				"ProjectId", "ExpInYear", "ProSkill", "Role");
		for (Manager manager : managers) {
			System.out.printf("%-10s %-15s %-25s %-15s %-15s %-15s %-15s %-15s\n", manager.getId(),
					manager.getFullName(), manager.getEmail(), "******", manager.getProjectId(), manager.getExpInYear(),
					"null", manager.getRole());
		}
	}

	public User login() {
		while (true) {
			System.out.println("Nhập vào Email của Account: ");
			String email = ScannerUtils.inputEmail("Email chưa đúng định dạng");
			System.out.println("Nhập password: ");
			String password = ScannerUtils.inputPassword("Password phải từ 6 đến 12 ký tự");
			try {
				return userController.login(email, password);
			} catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
			}
		}
	}
}