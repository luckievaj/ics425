package com.abc.model;

public class ContactName {

	private int contactid;
	private String firstName;
	private String lastName;
	private String userName;
	
	public int getcontactid() {
		return contactid;
	}
	public void setcontactid(int contactid) {
		this.contactid = contactid;
	}
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User [contactid=" + contactid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", username=" + userName + "]";
	}
	
	
}