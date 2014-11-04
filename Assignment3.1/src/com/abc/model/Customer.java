package com.abc.model;

public class Customer {
	private String firstName;
	private String lastName;
	private Address address;
	private Credentials credentials;
	
	public Customer() {
	}
	public Customer(String firstName, String lastName, Address address, Credentials credentials) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.credentials = credentials;
	}

	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getFirstName() { return firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public String getLastName() { return lastName; }
	public void setAddress(Address addr) { this.address = addr;}
	public Address getAddress(){	return address; }
	public void setCredentials(Credentials credentials) { this.credentials = credentials;}
	public Credentials getCredentials(){	return credentials; }	
	
	public boolean validate() { 
		return (!isEmpty(firstName) && !isEmpty(lastName)); 
	}
	private boolean isEmpty(String s) { return (s == null || s.length() == 0); }

}