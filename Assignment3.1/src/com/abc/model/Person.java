package com.abc.model;

public class Person {
	 private String firstName;
	    private String lastName;
	    public void setFirstName(String firstName) { this.firstName = firstName; }
	    public String getFirstName() { return firstName; }
	    public void setLastName(String lastName) { this.lastName = lastName; }
	    public String getLastName() { return lastName; }
	    public boolean validate() { 
	      return (!isEmpty(firstName) && !isEmpty(lastName)); 
	    }
	    private boolean isEmpty(String s) { return (s == null || s.length() == 0); }
	}

