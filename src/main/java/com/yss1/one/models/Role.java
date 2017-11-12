package com.yss1.one.models;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
	private long id;
	private String roleName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String getAuthority() {
		return roleName;
	}

}
