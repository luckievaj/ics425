package com.abc.model;

public class Contact {
	private int contactId;
	public String firstName;
	public String lastName;
	public Address address;
	public Phone phone;
	public Email email;
	public Credentials credentials;

	public Contact() {
	}
	public Contact(int contactId, String firstName, String lastName, Address address, Phone phone, Email email, Credentials credentials) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.credentials = credentials;

	}
	public void setContactId(int contactId) {this.contactId = contactId;}
	public int getContactId() {return contactId;}
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getFirstName() { return firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public String getLastName() { return lastName; }
	public void setAddress(Address addr) { this.address = addr;}
	public Address getAddress(){	return address; }
	public void setPhone(Phone phn) { this.phone = phn;}
	public Phone getPhone(){	return phone; }
	public void setEmail(Email eml) { this.email = eml;}
	public Email getEmail(){	return email; }
	public void setCredentials(Credentials cred) { this.credentials = cred;}
	public Credentials getCredentials(){	return credentials; }

	public boolean validate() { 
		return (!isEmpty(firstName) && !isEmpty(lastName)); 
	}
	private boolean isEmpty(String s) { return (s == null || s.length() == 0); }

	
}
