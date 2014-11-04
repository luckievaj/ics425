package com.abc.model;

public class Address {
private String street;
   private String city;
   private String state;
   private String zipCode;
   private String phone1;
   private String phone2;
   private String email1;
   private String email2;

   public Address() {
return;}

public Address(String street, String city, String state, String zipCode, String phone1, String phone2, String email1, String email2) {
this.street = street;
this.city = city;
this.state = state;
this.zipCode = zipCode;
this.phone1 = phone1;
this.phone2 = phone2;
this.email1 = email1;
this.email2 = email2;

}
   
   public String getStreet() { return street; }
   public void setStreet(String street) { this.street = street; }
   public String getCity() { return city; }
   public void setCity(String city) { this.city = city; }
   public String getState() { return state; }
   public void setState(String state) { this.state = state; }
   public String getZipCode() { return zipCode; }
   public void setZipCode(String zipCode) { this.zipCode = zipCode; }
public String getPhone1() {
return phone1;
}
public void setPhone1(String phone1) {
this.phone1 = phone1;
}
public String getPhone2() {
return phone2;
}
public void setPhone2(String phone2) {
this.phone2 = phone2;
}
public String getEmail1() {
return email1;
}
public void setEmail1(String email1) {
this.email1 = email1;
}
public String getEmail2() {
return email2;
}
public void setEmail2(String email2) {
this.email2 = email2;
}
public boolean validate() { 
     return (!isEmpty(street) && !isEmpty(city) && !isEmpty(state) 
       && !isEmpty(zipCode)); 
   }
   private boolean isEmpty(String s) { return (s == null || s.length() == 0); }




}