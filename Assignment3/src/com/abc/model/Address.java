package com.abc.model;

public class Address {
	private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String email;
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) {this.phone = phone;}
    public String getEmail() { return email;}
    public void setEmail(String email) {this.email = email;}
    public boolean validate() { 
      return (!isEmpty(street) && !isEmpty(city) && !isEmpty(state) 
        && !isEmpty(zipCode)); 
    }
    private boolean isEmpty(String s) { return (s == null || s.length() == 0); }
}


