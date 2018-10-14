package com.test.Dto;

public class User {
	
	private String firstName;
	private String lastName;
	private String userType;
	private Period period;
	 
	 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	 
	 

	
	
}
