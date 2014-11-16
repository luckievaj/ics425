package com.abc.model;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private Address address;
	private Phone phone;
	private Email email;
	private Credentials credentials;

	public Customer() {
	}
	public Customer(int customerId, String firstName, String lastName, Address address, Phone phone, Email email, Credentials credentials) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.credentials = credentials;

	}

	public void setCustomerID(int customerId) {this.customerId = customerId;}
	public int getCustomerID() {return customerId;}
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