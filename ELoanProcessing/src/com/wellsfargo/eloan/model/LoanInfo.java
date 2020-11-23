package com.wellsfargo.eloan.model;

public class LoanInfo {
	private Integer applno;
	 private String purpose;
	 private int amtrequest;
	 private String doa;
	 private String bstructure;
	 private String bindicator;
	 private String address;
	 @Override
	public String toString() {
		return "LoanInfo [applno=" + applno + ", purpose=" + purpose + ", amtrequest=" + amtrequest + ", doa=" + doa
				+ ", bstructure=" + bstructure + ", bindicator=" + bindicator + ", address=" + address + ", email="
				+ email + ", mobile=" + mobile + ", status=" + status + "]";
	}
	private String email;
	 private String mobile;
	 private String status;
	private String tIndicator;
	private String loanname;
	 public LoanInfo() {
		 
	 }
	 public LoanInfo(Integer applno, String purpose, int amtrequest, String doa, String bstructure, String bindicator,
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

	public LoanInfo( String loanname, Integer amtrequest2, String date,
			String bstructure2, String bindicator2, String tIndicator, String mobile2, String email2, String address2,
			String status2) {
		super();
		this.loanname=loanname;
		
		this.tIndicator = tIndicator;
		this.amtrequest = amtrequest2;
		this.doa = date;
		this.bstructure = bstructure2;
		this.bindicator = bindicator2;
		this.address = address2;
		this.email = email2;
		this.mobile = mobile2;
		this.status=status2;
	}
	public Integer getApplno() {
		return applno;
	}
	public void setApplno(Integer applno) {
		this.applno = applno;
	}
	public String gettIndicator() {
		return tIndicator;
	}
	public void settIndicator(String tIndicator) {
		this.tIndicator = tIndicator;
	}
	public String getLoanname() {
		return loanname;
	}
	public void setLoanname(String loanname) {
		this.loanname = loanname;
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

}
