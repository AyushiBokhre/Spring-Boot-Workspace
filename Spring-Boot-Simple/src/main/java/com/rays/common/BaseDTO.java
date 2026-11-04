package com.rays.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseDTO implements DropdownListBean {
	
	@Id
	@GeneratedValue(generator = "raypk")
	@GenericGenerator(name = "raypk", strategy = "native")
	@Column(name = "ID")
	protected Long id;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String getKey() {
		return id+"";
	}

	
}
