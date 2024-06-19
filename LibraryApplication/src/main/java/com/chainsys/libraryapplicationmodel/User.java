package com.chainsys.libraryapplicationmodel;

public class User {
	int id;
	String name;
	String emailId;
	String password;
	String type;
	Long phoneNumber;
	String location;
	public static int getStatus;	
	 
	public User(){
		
	}
	
	public User(int id, String name, String emailId, String password, String type, Long phoneNumber, String location) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.type = type;
		this.phoneNumber = phoneNumber;
		this.location = location;
	}
	
	
	public int getGetStatus() {
		return getStatus;
	}

	public void setGetStatus(int getStatus) {
		this.getStatus = getStatus;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	//toString
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emailId=" + emailId + ", password=" + password + ", type="
				+ type + ", phoneNumber=" + phoneNumber + ", location=" + location + "]";
	}
	
	
	
	
}
