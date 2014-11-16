package com.abc.model;

public class User {
	private String firstName;
	private String lastName;
	private String userName;
//	private Address address;
//	private Phone phone;
//	private Email email;

	public User() {
	}
	public User(String firstName, String lastName, String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
//		this.address = address;
//		this.phone = phone;
//		this.email = email;
	}
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getFirstName() { return firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public String getLastName() { return lastName; }
	public void setUserName(String userName) { this.userName = userName; }
	public String getUserName() { return userName; } 
//	public void setAddress(Address addr) { this.address = addr;}
//	public Address getAddress(){	return address; }
//	public void setPhone(Phone phn) { this.phone = phn;}
//	public Phone getPhone(){	return phone; }
//	public void setEmail(Email eml) { this.email = eml;}
//	public Email getEmail(){	return email; }

	public boolean validate() { 
		return (!isEmpty(firstName) && !isEmpty(lastName) && !isEmpty(userName)); 
	}
	private boolean isEmpty(String s) { return (s == null || s.length() == 0); }

}