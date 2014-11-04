package com.abc.model;

import com.ics425.model.Address;

public class Customer {
	private String firstName;
	private String lastName;
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getFirstName() { return firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public String getLastName() { return lastName; }
	
	private com.abc.model.Address address;
	public Address getAddress() { return address;}
	public void setAddress(Address address) {this.address = address;}
	public boolean validate() { 
		return (!isEmpty(firstName) && !isEmpty(lastName)); 
	}
	private boolean isEmpty(String s) { return (s == null || s.length() == 0); }
}

