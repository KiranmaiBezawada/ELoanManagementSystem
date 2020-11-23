package com.wellsfargo.eloan.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.eloan.dao.ConnectionDao;
import com.wellsfargo.eloan.model.User;
import com.wellsfargo.eloan.model.LoanInfo;

public class Usercontrollerimplimentation  {
	private ConnectionDao connDao;
	
	
	public Boolean validateuser(String userName,String password) {
		boolean login=false;
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root");
					PreparedStatement pt = con.prepareStatement("SELECT * FROM user");
			ResultSet rs = pt.executeQuery();
			System.out.println("after executing query");
		 while(rs.next()){
            String dbUsername = rs.getString("username");
            System.out.println(dbUsername);
            String  dbPassword = rs.getString("password");
             if(dbUsername.equals(userName) && dbPassword.equals(password)){
                 System.out.println("OK");
                 login = true;
             }
             System.out.println(userName + password + " " + dbUsername + dbPassword);
             System.out.println(login);
         }}
		catch(SQLException exception) {
			System.out.println(exception.getMessage());
		}
	return login;

}


	public Boolean register(String userName, String password) {
		boolean reg=false;
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root");
					PreparedStatement pt = con.prepareStatement("SELECT username FROM user");
			ResultSet rs = pt.executeQuery();
		 while(rs.next()){
            String dbUsername = rs.getString("username");
             if(dbUsername.equals(userName) ){
                 System.out.println("username in use");
                  reg = true;
             }
            
         }}
		catch(SQLException exception) {
			System.out.println(exception.getMessage());
		}
	return reg;
	}
	public Boolean loanRequestDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
 boolean details=false;
 
		try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root")){
			System.out.println("connected!");
			int applicationnumber=0;
			 ResultSet rs=((Statement) con).executeQuery("SELECT applno FROM loaninfo");				
				if(rs.last()){					
					 applicationnumber=rs.getInt("applno")+1;
					 }									
				   System.out.println(applicationnumber);
				  String loanname=  request.getParameter("loanname");				   
				   Integer amtrequest=Integer. parseInt(request.getParameter("amtrequest"));
				   String  date=request.getParameter("date");
				   String bstructure=request.getParameter("bstructure");
				   String bindicator=request.getParameter("bindicator");
				   String tIndicator=request.getParameter("tIndicator");
				   String mobile=request.getParameter("mobile");
				   String email= request.getParameter("email");
				   String address=  request.getParameter("address");
				   String status="new"; 				  
				   Integer applno=applicationnumber;
				   System.out.println(loanname);
				  
				PreparedStatement pt1 = con.prepareStatement("INSERT INTO loanInfo(loan_name,amtrequest,applcationdate,bstructure,bindicator,tIndicator,mobile_number,email,address,status,applno) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			  	LoanInfo linfo=new LoanInfo(loanname,amtrequest,date,bstructure,bindicator,tIndicator,mobile,email,address,status);
			  
				/*   
				   PreparedStatement pt = con.prepareStatement("INSERT INTO loanInfo(username,loan_name,applno) VALUES(?,?,?)");
				  	LoanInfo linf=new LoanInfo(username,loanname,applno);*/
				   					   
			  	pt1.setString(1,linfo.getLoanname());			  
				pt1.setInt(2,linfo.getAmtrequest());
				pt1.setString(3,linfo.getDoa());
				pt1.setString(4,linfo.getBstructure());
				pt1.setString(5,linfo.getBindicator() );
				pt1.setString(6,linfo.gettIndicator());
				pt1.setString(7,linfo.getMobile());
				pt1.setString(8,linfo.getEmail());
				pt1.setString(9,linfo.getAddress());
				pt1.setString(10,linfo.getStatus());
				pt1.setInt(11,linfo.getApplno()); 
				
				
				int rowsEffected = pt1.executeUpdate();				
				System.out.println(rowsEffected + " records inserted!" );
				details=true;
				con.close();
				
		   }
				catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   
					 		         
		   
		return details;
	}


	public Boolean userloandetails(String applicationnumber) throws SQLException {
		boolean loan=false;
		Integer applicationno=Integer.parseInt("applicationnumber");
		try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root")){
			System.out.println("connected!");
			Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from loanInfo where applno=?");  
            while (rs.next()) 
            {  
            	String loanname = rs.getString("loan_name");                    
            	 int applno= rs.getInt("applno");   
            	int amtrequest = rs.getInt("amtrequest");
            	 String bstructure = rs.getString("bstructure"); 
            	 String applcationdate = rs.getString("applcationdate"); 
            	 String bindicator = rs.getString("bindicator"); 
            	 String address = rs.getString("address"); 
            	 String mobilenumber = rs.getString("mobile_number"); 
            	 String email = rs.getString("email"); 
            	 String status = rs.getString("status"); 
            	 String tindicator = rs.getString("tindicator"); 
			}
		
          //  request.setAttribute("loanname", "loanname");
            
		return null;
	}
	}
}
