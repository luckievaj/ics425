package com.abc.model;

public class Email {
	private String email1;
	private String email2;
	
	public Email() { }
	
	public Email (String email1, String email2){
		this.email1 = email1;
		this.email2 = email2;
	}
	
	public void setEmail1(String email1) { this.email1 = email1;}
	public String getEmail1() {	return email1;}

	public void setEmail2(String email2) { this.email2 = email2;}
	public String getEmail2() {	return email2;}

    public boolean validate() { 
        return (!isEmpty(email1) && !isEmpty(email2)); 
      }
      private boolean isEmpty(String s) { return (s == null || s.length() == 0); }

  }
