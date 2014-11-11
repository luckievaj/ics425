package com.abc.model;

public class Customer {
	private String firstName;
	private String lastName;
	private Address address;
	private Credentials credentials;
	private Phone phone;
	private Email email;

	public Customer() {
	}
	public Customer(String firstName, String lastName, Address address, Credentials credentials, Phone phone, Email email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.credentials = credentials;
		this.phone = phone;
		this.email = email;

	}

	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getFirstName() { return firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public String getLastName() { return lastName; }
	public void setAddress(Address addr) { this.address = addr;}
	public Address getAddress(){	return address; }
	public void setCredentials(Credentials cred) { this.credentials = cred;}
	public Credentials getCredentials(){	return credentials; }	
	public void setPhone(Phone phn) { this.phone = phn;}
	public Phone getPhone(){	return phone; }
	public void setEmail(Email eml) { this.email = eml;}
	public Email getEmail(){	return email; }

	public boolean validate() { 
		return (!isEmpty(firstName) && !isEmpty(lastName)); 
	}
	private boolean isEmpty(String s) { return (s == null || s.length() == 0); }

}