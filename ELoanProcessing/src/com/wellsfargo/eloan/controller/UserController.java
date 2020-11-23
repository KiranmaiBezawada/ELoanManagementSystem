package com.wellsfargo.eloan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.eloan.dao.ConnectionDao;
import com.wellsfargo.eloan.model.User;
import com.wellsfargo.eloan.service.Usercontrollerimplimentation;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ConnectionDao connDao;
public Usercontrollerimplimentation user1=new Usercontrollerimplimentation();
	
	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}
	public void init(ServletConfig config) {
		
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
		try {
			 Connection jdbcConnection=null;
			if (jdbcConnection == null || jdbcConnection.isClosed()) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Connected!");
				} catch (ClassNotFoundException e) {
					throw new SQLException(e);
				}
				jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName=registernewuser(request,response);
				break;
			case "validate":
				viewName=validate(request,response);
				break;
			case "placeloan":
				viewName=placeloan(request,response);
				break;
			case "application1":
				viewName=application1(request,response);
				break;
			case "editLoanProcess"  :
				viewName=editLoanProcess(request,response);
				break;
			case "registeruser":
				viewName=registerUser(request,response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;	
			case  "displaystatus" :
				viewName=displaystatus(request,response);
				break;
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());
		}
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	}
	private String validate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(userName + "   userName" );
		System.out.println(password + "   password" );
		try {
		  if(userName.equals("admin") && password.equals("admin")){
			  RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminhome1.jsp");
		        requestDispatcher.forward(request, response);
		        }
		  else 
		  { 
			  Boolean login=user1.validateuser( userName, password);		  
		  try {
			  				if(login==true) {
					 RequestDispatcher requestDispatcher = request.getRequestDispatcher("userhome.jsp");
					 		        requestDispatcher.forward(request, response);}
				else			   
				   {response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<html><head><title>register</title></head><body>");
					out.println("<h1 align=\"center\"> !Please register.Click on Register here</h1></body></html>");}
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);	
				  }
		  catch(ServletException | IOException exception) {
				System.out.println(exception.getMessage());}
		  }}
		  catch(ServletException | IOException exception) {
				System.out.println(exception.getMessage());}
		  	return null;
	}
	private String application1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
		  
			  				Boolean details=user1.loanRequestDetails( request, response);	
			  				try {
			  				if(details==true) {
				  					response.setContentType("text/html");
									PrintWriter out = response.getWriter();
									out.println("<html><head><title>application submitted</title></head><body>");
									out.println("<h4>Your loan application is Successfull!</h4>\n" + 
											"	<h4>Please note your application number </h4>");			  				
									Class.forName("com.mysql.jdbc.Driver").newInstance();
									Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
									Statement st = conn.createStatement();
									ResultSet rs=st.executeQuery("SELECT applno FROM loaninfo");
									int applicationnumber=0;
													if(rs.last()){
														applicationnumber=rs.getInt("accnum")+1;}
													request.setAttribute("applicationnumber", String.valueOf(applicationnumber));
													}			  				
			  						RequestDispatcher requestDispatcher = request.getRequestDispatcher("userhome1.jsp");
						 		        requestDispatcher.forward(request, response);
						 		        
		  					/*else 
		  							try {
				  				RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("errorPage.jsp");
			 		        requestDispatcher1.forward(request, response);
		  							}	
		  							catch(Exception e){}*/
		  }
		  catch(Exception e){}
		  return null;
	}
	private String placeloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write the code to display the loan application page */
		
		return null;
	}
	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to edit the loan info */
		
		return null;
	}
	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to redirect page to read the user details */
		return "newuserui.jsp";
	}
	private String registernewuser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(userName + "   userName" );
		System.out.println(password + "   password" );
		
		Boolean reg=user1.register( userName, password);
		try {
				if(reg==true) {			
					response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        out.println("<html><head><title>register</title></head><body>");
				out.println("<h1 align=\"center\"> Username already in use ,please Enter New Name </h1></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.include(request, response);		  }
				else {	
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
					PreparedStatement pt = conn.prepareStatement("INSERT INTO user values(?,?)");
					User user=new User(userName,password);
					pt.setString(1, user.getUsername());
					pt.setString(2, user.getPassword());
					
					int rowsEffected = pt.executeUpdate();
					
					System.out.println(rowsEffected + " records inserted!" );
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("userhome.jsp");
		        requestDispatcher.forward(request, response);}
	    	}
	     catch(ServletException | IOException exception) {
				System.out.println(exception.getMessage());}
	     
	     return null;	
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to redirect to register page */
		
		return null;
	}
	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code the display the loan status based on the given application
		   number 
		*/
		
		return null;
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to editloan page */
		return null;
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		String applicationnumber = request.getParameter("applno");
		
		System.out.println(applicationnumber + "   applno" );
		
		
	//	Boolean reg=user1.userloandetails(applicationnumber);
		return null;
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to trackloan page */
		return null;
	}
}