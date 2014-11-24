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
		return "contactName [contactId=" + contactId + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
