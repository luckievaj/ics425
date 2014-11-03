package com.abc.model;

public class Credentials {
	 private String username;
	    private String password;
	    public void setUsername(String username) { this.username = username; }
	    public String getUsername() { return username; }
	    public void setPassword(String password) { this.password = password; }
	    public String getPassword() { return password; }
	    public boolean validate() { 
	      return (!isEmpty(username) && !isEmpty(password)); 
	    }
	    private boolean isEmpty(String s) { return (s == null || s.length() == 0); }
	}

