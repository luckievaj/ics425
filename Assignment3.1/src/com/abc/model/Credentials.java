package com.abc.model;

public class Credentials {
	private String ann_date1;
	private String ann_desc1;
	public void setAnn_Date1(String ann_date1) { this.ann_date1 = ann_date1; }
	public String getAnn_Date1() { return ann_date1; }
	public void setAnn_Desc1(String ann_desc1) { this.ann_desc1 = ann_desc1; }
	public String getAnn_Desc1() { return ann_desc1; }

	private String ann_date2;
	private String ann_desc2;
	public void setAnn_Date2(String ann_date1) { this.ann_date2 = ann_date1; }
	public String getAnn_Date2() { return ann_date2; }
	public void setAnn_Desc2(String ann_desc1) { this.ann_desc2 = ann_desc1; }
	public String getAnn_Desc2() { return ann_desc2; }

	private String ann_date3;
	private String ann_desc3;
	public void setAnn_Date3(String ann_date3) { this.ann_date3 = ann_date3; }
	public String getAnn_Date3() { return ann_date3; }
	public void setAnn_Desc3(String ann_desc3) { this.ann_desc3 = ann_desc3; }
	public String getAnn_Desc3() { return ann_desc3; }

	public boolean validate() { 
		return (!isEmpty(ann_date1) && !isEmpty(ann_desc1)||!isEmpty(ann_date2) && !isEmpty(ann_desc2)||!isEmpty(ann_date3) && !isEmpty(ann_desc3)); 
	}
	private boolean isEmpty(String s) { return (s == null || s.length() == 0); }
}

