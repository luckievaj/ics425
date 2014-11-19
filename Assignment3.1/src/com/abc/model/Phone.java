package com.abc.model;

public class Phone {
	private String phone1;
	private String phone2;
	
	public Phone() { }
	
	public Phone (String phone1, String phone2){
		this.phone1 = phone1;
		this.phone2 = phone2;
	}
	
	public void setPhone1(String phone1) { this.phone1 = phone1;}
	public String getPhone1() {	return phone1;}

	public void setPhone2(String phone2) { this.phone2 = phone2;}
	public String getPhone2() {	return phone2;}
    
	public boolean validate() { 
        return (!isEmpty(phone1) && !isEmpty(phone2)); 
      }
      private boolean isEmpty(String s) { return (s == null || s.length() == 0); }

  }
