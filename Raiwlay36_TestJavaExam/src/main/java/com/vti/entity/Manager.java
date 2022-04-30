package com.vti.entity;

public class Manager extends User{
	private int expInYear;
	
	public Manager(int id, String fullName, String email, String passWord, int projectId, int expInYear, Role role) {
		super(id, fullName, email, passWord, projectId, Role.MANAGER);
		this.expInYear = expInYear;
	}

	public int getExpInYear() {
		return expInYear;
	}
	
}
