package com.pig.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {

	private Integer id;
	private String name;
	private Date birthData;
	
	public User(Integer id, String name, Date birthData) {
		super();
		this.id = id;
		this.name = name;
		this.birthData = birthData;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthData() {
		return birthData;
	}

	public void setBirthData(Date birthData) {
		this.birthData = birthData;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthData=" + birthData + "]";
	}
	
	
}
