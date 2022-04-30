package com.vti.entity;

public class Employee extends User {
	private String proSkill;

	public Employee(int id, String fullName, String email, String passWord, int projectId, String proSkill, Role role) {
		super(id, fullName, email, passWord, projectId, Role.EMPLOYEE);
		this.proSkill = proSkill;
	}

	public String getProSkill() {
		return proSkill;
	}
}
