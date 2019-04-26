package com.admin.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Admin {
	private String id;
	private String username;
	private String password;
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
