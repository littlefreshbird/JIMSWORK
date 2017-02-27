package com.jims.work.bean;


public class User {
	public String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String password;
}
