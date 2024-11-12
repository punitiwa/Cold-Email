package com.spring.boot.model;


public class User {
	private String first_name;
	private String last_name;
    private String email;
    private String company_name;
    private String email_status;
    
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getEmail_status() {
		return email_status;
	}
	public void setEmail_status(String email_status) {
		this.email_status = email_status;
	}
	
}
