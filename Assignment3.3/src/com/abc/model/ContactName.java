package com.abc.model;

public class ContactName {

	private int contactId;
	private String firstName;
	private String lastName;
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
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
	@Override
	public String toString() {
		return "User [contactId=" + contactId + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	
}
