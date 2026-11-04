package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;
@Entity
@Table(name = "ST_USER")
public class UserDTO extends BaseDTO {
	
	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 50)
	private String lastName;
	
	@Column(name = "LOGIN", length = 50)
	private String login;
	
	@Column(name = "PASSWORD", length = 50)
	private String password;
	
	@Column(name = "ROLE_ID", length = 50)
	private Long roleId;
	
	@Column(name = "ROLE_NAME", length = 50)
	private String roleName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String getValue() {
		return null;
	}

}
