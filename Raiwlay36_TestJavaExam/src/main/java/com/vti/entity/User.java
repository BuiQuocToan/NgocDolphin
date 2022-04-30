package com.vti.entity;

public class User {
	private int id;
	private String fullName;
	private String email;
	private String passWord;
	private int projectId;
	private Role role;

	public int getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassWord() {
		return passWord;
	}

	public int getProjectId() {
		return projectId;
	}

	public Role getRole() {
		return role;
	}

	public User(int id, String fullName, String email, String passWord, int projectId, Role role) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.passWord = passWord;
		this.projectId = projectId;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", projectId=" + projectId + ", role="
				+ role + "]";
	}

}
