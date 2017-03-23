package com.jims.work.bean;


import java.io.Serializable;

public class User  implements Serializable {


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Long id;
	public String account;
	public String password;
	private String userIcon;


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserIcon() {

		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}






	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
	}

}
