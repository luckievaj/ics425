package com.abc.model;

public class Credentials {
	private String annDate1;
	private String annDesc1;
	private String annDate2;
	private String annDesc2;
	private String annDate3;
	private String annDesc3;
	
	public Credentials(){
	}
	public Credentials (String annDate1, String annDesc1, String annDate2, String annDesc2, String annDate3, String annDesc3){
		this.annDate1 = annDate1;
		this.annDesc1 = annDesc1;
		this.annDate2 = annDate2;
		this.annDesc2 = annDesc2;
		this.annDate3 = annDate3;
		this.annDesc3 = annDesc3;
	}
	
	public void setAnnDate1(String annDate1) { this.annDate1 = annDate1; }
	public String getAnnDate1() { return annDate1; }
	public void setAnnDesc1(String annDesc1) { this.annDesc1 = annDesc1; }
	public String getAnnDesc1() { return annDesc1; }


	public void setAnnDate2(String annDate2) { this.annDate2 = annDate2; }
	public String getAnnDate2() { return annDate2; }
	public void setAnnDesc2(String annDesc2) { this.annDesc2 = annDesc2; }
	public String getAnnDesc2() { return annDesc2; }


	public void setAnnDate3(String annDate3) { this.annDate3 = annDate3; }
	public String getAnnDate3() { return annDate3; }
	public void setAnnDesc3(String annDesc3) { this.annDesc3 = annDesc3; }
	public String getAnnDesc3() { return annDesc3; }

	public boolean validate() { 
		return (!isEmpty(annDate1) && !isEmpty(annDesc1)||!isEmpty(annDate2) && !isEmpty(annDesc2)||!isEmpty(annDate3) && !isEmpty(annDesc3)); 
	}
	private boolean isEmpty(String s) { return (s == null || s.length() == 0); }
}


