package com.wellsfargo.eloan.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Admincontrollerimplimentation {
	public boolean listAll(HttpServletRequest request, HttpServletResponse response) {
		boolean list=false;
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root");
			 response.setContentType("text/html");
             PrintWriter out = response.getWriter(); 
             PreparedStatement ps=con.prepareStatement("select * from loanInfo");
             out.print("<html><body><center><h1>List of all applications:</h1></center>");
             out.print("<div align=right><a href=index.jsp>Logout</a></div>");
             out.print("<div align=right><a href=adminhome1.jsp>Home</a></div>"); 
             
             out.print("<table border=1><tr><td>Loan name</td><td>Application number</td><td>AmountRequested</td>");
             out.print("<td>Bussiness Structure</td><td>Billing Indicator</td><td>Tax Indicator</td><td>Mobile</td>");
             out.print("<td>Email</td><td>Status</td></tr>");
             ResultSet rs=ps.executeQuery();  
             while(rs.next()){            	 
            	 out.print("<tr>");
            	 out.print("<td>"+rs.getString("loan_name")+"</td>");
            	 out.print("<td>"+rs.getString("applno")+"</td>");
            	 out.print("<td>"+rs.getString("amtrequest")+"</td>");
            	 out.print("<td>"+rs.getString("bstructure")+"</td>");
            	 out.print("<td>"+rs.getString("bindicator")+"</td>");
            	 out.print("<td>"+rs.getString("tIndicator")+"</td>");
            	 out.print("<td>"+rs.getString("mobile_number")+"</td>");
            	 out.print("<td>"+rs.getString("email")+"</td>");
            	 out.print("<td>"+rs.getString("status")+"</td>");
            	 out.print(" </tr>");
            	 }
             con.close();
        	 list=true;
		
		}
			catch(SQLException | IOException exception) {
				System.out.println(exception.getMessage());
			}
		
		return list;
	}}
