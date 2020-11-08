package com.wellsfargo.elps.model;

import java.util.Date;

public class LoanInfo {
	private String username;;
	private Integer applno;
	 private String purpose;
	 private Integer amtrequest;
	 private String doa;
	 private String bstructure;
	 private String bindicator;
	 private String tIndicator;
	 private String Mobile;
	 public String gettIndicator() {
		return tIndicator;
	}
	public void settIndicator(String tIndicator) {
		this.tIndicator = tIndicator;
	}
	private String address;
	 private String loanname;
	 private String date;
	 public String getLoanname() {
		return loanname;
	}
	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}
	public String getDate() {
		return  date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "LoanInfo [applno=" + applno + ", purpose=" + purpose + ", amtrequest=" + amtrequest + ", doa=" + doa
				+ ", bstructure=" + bstructure + ", bindicator=" + bindicator + ", address=" + address + ", email="
				+ email + ", mobile=" + mobile + ", status=" + status + "]";
	}
	private String email;
	 private String mobile;
	 private String status;
	 public LoanInfo() {
		 
	 }
	 public LoanInfo(Integer applno, String purpose, Integer amtrequest, String doa, String bstructure, String bindicator,
			String address, String email, String mobile,String status) {
		super();
		this.applno = applno;
		this.purpose = purpose;
		this.amtrequest = amtrequest;
		this.doa = doa;
		this.bstructure = bstructure;
		this.bindicator = bindicator;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.status=status;
	}

	
	
	public LoanInfo(String loanname2, Integer applno2, Integer amtrequest2, String date2, String bstructure2,
			String bindicator2, String tIndicator2, String mobile2, String email2, String address2) {
		// TODO Auto-generated constructor stub
	}
	public LoanInfo(String loanname2) {
				super();
		this.loanname = loanname2;
	}
	public LoanInfo(String username2, String loanname2, Integer applno2) {
		this.username = username2;
		this.loanname = loanname2;
		this.applno = applno2;
	}
	public LoanInfo(String username2, String loanname2, Integer applno2, Integer amtrequest2, String date2,
			String bstructure2, String bindicator2, String tIndicator2, String mobile2, String email2,
			String address2,String status2) {
		this.username = username2;
		this.loanname = loanname2;
		this.applno = applno2;
		this.amtrequest = amtrequest2;
		this.date = date2;
		this.bstructure = bstructure2;
		this.bindicator = bindicator2;
		this.tIndicator = tIndicator2;
		this.mobile = mobile2;
		this.email = email2;
		this.address = address2;
		this.status = status2;
	}
	public Integer getApplno() {
		return applno;
	}
	public void setApplno(Integer applno) {
		this.applno = applno;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getAmtrequest() {
		return amtrequest;
	}
	public void setAmtrequest(int amtrequest) {
		this.amtrequest = amtrequest;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	public String getBstructure() {
		return bstructure;
	}
	public void setBstructure(String bstructure) {
		this.bstructure = bstructure;
	}
	public String getBindicator() {
		return bindicator;
	}
	public void setBindicator(String bindicator) {
		this.bindicator = bindicator;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public String getStatus() {
		return status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAmtrequest(Integer amtrequest) {
		this.amtrequest = amtrequest;
	}
	

}
