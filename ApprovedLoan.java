package com.wellsfargo.elps.model;

import java.util.Date;

public class ApprovedLoan {
	Integer applno;
	int amotsanctioned;
	int loanterm;
	Date PaymentstartDate;
	Date  LoanclosureDate;
	int Emi;
	int Termpaymentamount;
	
	public ApprovedLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ApprovedLoan(Integer applno, Integer amountSanctioned, Date paymentstartDate2, Integer termofloan, Integer interestrate,
			Integer monthlypayment2, Integer termpaymentamount2,Date loancloserdate2) {
		this.applno = applno;
		this.amotsanctioned = amountSanctioned;
		this.loanterm = termofloan;
		this.PaymentstartDate = paymentstartDate2;
		this.LoanclosureDate = loancloserdate2;
		this.Emi = monthlypayment2;
		this.Termpaymentamount=termpaymentamount2;
	}
	

	public Integer getApplno() {
		return applno;
	}

	public void setApplno(Integer applno) {
		this.applno = applno;
	}

	public int getAmotsanctioned() {
		return amotsanctioned;
	}

	public void setAmotsanctioned(int amotsanctioned) {
		this.amotsanctioned = amotsanctioned;
	}

	public int getLoanterm() {
		return loanterm;
	}

	public void setLoanterm(int loanterm) {
		this.loanterm = loanterm;
	}

	public Date getPsd() {
		return PaymentstartDate;
	}

	public void setPsd(Date psd) {
		this.PaymentstartDate = psd;
	}

	public Date getLcd() {
		return LoanclosureDate;
	}

	public void setLcd(Date lcd) {
		this.LoanclosureDate = lcd;
	}

	public int getEmi() {
		return Emi;
	}

	public void setEmi(int emi) {
		this.Emi = emi;
	}

	@Override
	public String toString() {
		return "ApprovedLoan [applno=" + applno + ", amotsanctioned=" + amotsanctioned + ", loanterm=" + loanterm
				+ ", psd=" + PaymentstartDate + ", lcd=" + LoanclosureDate + ", emi=" + Emi + "]";
	}
	
	
}
