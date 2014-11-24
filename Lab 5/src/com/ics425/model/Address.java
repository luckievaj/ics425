package com.ics425.model;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public boolean validate() { 
      return (!isEmpty(street) && !isEmpty(city) && !isEmpty(state) 
        && !isEmpty(zipCode)); 
    }
    private boolean isEmpty(String s) { return (s == null || s.length() == 0); }
}