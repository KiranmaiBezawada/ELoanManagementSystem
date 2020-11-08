package com.wellsfargo.elps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.elps.dao.ConnectionDao;
import com.wellsfargo.elps.model.ApprovedLoan;
import com.wellsfargo.elps.model.LoanInfo;
import com.wellsfargo.elps.model.User;


@WebServlet("/user")
public class UserController extends HttpServlet {
	
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }


    static ConnectionDao connDao;
User user=new User();
	
public static final String SELECT_BY_ID_QRY=
"SELECT username FROM user WHERE username=?";
	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException exception) {
			//System.out.println(exception.printStackTrace(););
			System.out.println(exception.getMessage());
			System.out.println("Driver not loaaded!");
			System.exit(0);
		}				
			
		String action = request.getParameter("action");			
			
		String viewName = "";
		try {
			switch (action) {
			case "process":
				viewName=process(request,response);
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
		

	

	private String validate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		 String dbUsername, dbPassword;
	        boolean login = false;
	        try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root")){
				
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(userName + "   userName" );
		System.out.println(password + "   password" );
		try {
		  if(userName.equals("admin") && password.equals("admin")){
			  RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminhome1.jsp");
		        requestDispatcher.forward(request, response);
		        }}
		  catch(ServletException exception) {
				System.out.println(exception.getMessage());}
		        
				
		PreparedStatement pt2 = con.prepareStatement("SELECT * FROM user");
		ResultSet rs = pt2.executeQuery();
		 while(rs.next()){
             dbUsername = rs.getString("username");
             dbPassword = rs.getString("password");
           

             if(dbUsername.equals(userName) && dbPassword.equals(password)){
                 System.out.println("OK");
                 login = true;
             }
             System.out.println(userName + password + " " + dbUsername + dbPassword);
         }}
		catch(SQLException exception) {
			System.out.println(exception.getMessage());}
	        
	        
	      
   try {
		if(login==true) {
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("userhome.jsp");
			 		        requestDispatcher.forward(request, response);}
   else
	   
   {response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	out.println("<html><head><title>Greet</title></head><body>");
	out.println("<h1 align=\"center\"> !Please register  </h1></body></html>");}
	
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.include(request, response);	
	
   }
		catch( ServletException exception) {
			System.out.println(exception.getMessage());}
	        
		return null;
	}
	private String placeloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write the code to place the loan information */
		
		return null;
	}
	private String application1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
				
		try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root")){
			System.out.println("connected!");
			String username=  request.getParameter("username");
				  String loanname=  request.getParameter("loanname");
				   Integer applno =Integer. parseInt(request.getParameter("applno"));
				   Integer amtrequest=Integer. parseInt(request.getParameter("amtrequest"));
				   String  date=request.getParameter("date");
				   String bstructure=request.getParameter("bstructure");
				   String bindicator=request.getParameter("bindicator");
				   String tIndicator=request.getParameter("tIndicator");
				   String mobile=request.getParameter("mobile");
				   String email= request.getParameter("email");
				   String address=  request.getParameter("address");
				   String status="new"; 
				   System.out.println(loanname);
				   
				PreparedStatement pt1 = con.prepareStatement("INSERT INTO loanInfo(username,loan_name,applno ,amtrequest,applcationdate,bstructure,bindicator,tIndicator,mobile_number,email,address,status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			  	LoanInfo linfo=new LoanInfo(username,loanname,applno,amtrequest,date,bstructure,bindicator,tIndicator,mobile,email,address,status);
			  
				/*   
				   PreparedStatement pt = con.prepareStatement("INSERT INTO loanInfo(username,loan_name,applno) VALUES(?,?,?)");
				  	LoanInfo linf=new LoanInfo(username,loanname,applno);*/
				  			
				  	pt1.setString(1,linfo.getUsername()); 					   
			  	pt1.setString(2,linfo.getLoanname());
			  	pt1.setInt(3,linfo.getApplno()); 
				pt1.setInt(4,linfo.getAmtrequest());
				pt1.setString(5,linfo.getDate());
				pt1.setString(6,linfo.getBstructure());
				pt1.setString(7,linfo.getBindicator() );
				pt1.setString(8,linfo.gettIndicator());
				pt1.setString(9,linfo.getMobile());
				pt1.setString(10,linfo.getEmail());
				pt1.setString(11,linfo.getAddress());
				pt1.setString(12,linfo.getStatus());
				
				int rowsEffected = pt1.executeUpdate();				
				System.out.println(rowsEffected + " records inserted!" );

		  		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("userhome1.jsp");
					 		        requestDispatcher.forward(request, response);
		   }
				catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   
					 		         
		   
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
	private String process(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, Exception {
		
			 
			 try(Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root")){
					System.out.println("connected!");
					Integer AmountSanctioned= Integer.parseInt(request.getParameter("as"));
					Date PaymentstartDate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("psd"));
					Integer Termofloan=  Integer.parseInt(request.getParameter("tol"));
					Integer interestrate=  Integer.parseInt(request.getParameter("ir"));
					Integer Termpaymentamount1 = ((AmountSanctioned ) * (1 + interestrate/100));
					Integer Termpaymentamount2 =  (int) Math.pow(Termpaymentamount1, Termofloan);
					Integer monthlypayment2=Termpaymentamount2/Termofloan;
					 String status=  request.getParameter("status");			
					System.out.println("monthlypayment2"+monthlypayment2);
					System.out.println("Termpaymentamount2"+Termpaymentamount2);
					request.setAttribute("monthlypayment2", String.valueOf(monthlypayment2)); 
					request.setAttribute("Termpaymentamount2", String.valueOf(Termpaymentamount2)); 
	             RequestDispatcher requestDispatcher = request.getRequestDispatcher("calemi.jsp");
	 		        requestDispatcher.forward(request, response);
	 		       /*   Integer amountSanctioned=AmountSanctioned; Date paymentstartDate2=PaymentstartDate; Integer termofloan=Termofloan; Integer  interestrate1=interestrate1;
	 		      Integer  monthlypayment21=monthlypayment21;  Integer termpaymentamount2=Termpaymentamount2;Date loancloserdate2=loancloserdate2;
	 		      Integer applno=applno;
	 		        if(status=="Approve")
	 		        {
	 		        	PreparedStatement pt1 = con.prepareStatement("INSERT INTO approvedloan(AmountSanctioned,PaymentstartDate,Termofloan ,interestrate,monthlypayment2,Termpaymentamount2) VALUES(AmountSanctioned,'PaymentstartDate',Termofloan ,interestrate,monthlypayment2,Termpaymentamount2)");
	 				  	ApprovedLoan app=new ApprovedLoan( applno, amountSanctioned, paymentstartDate2, termofloan,  interestrate1,
	 							 monthlypayment21,  termpaymentamount2, loancloserdate2)
	 						pt1.setString(1,app.getAmotsanctioned()); 					   
	 				  	pt1.setString(2,app.getPaymentstartDate);
	 				  	pt1.setInt(3,app.); 
	 					pt1.setInt(4,app.);
	 					pt1.setString(5,app.);
	 					pt1.setString(6,app.);
	 					pt1.setString(7,app. );
	 					pt1.setString(8,app.);
	 					pt1.setString(9,app.);
	 					pt1.setString(10,app);
	 					pt1.setString(11,app.);
	 					pt1.setString(12,app.);
	 					
	 					int rowsEffected = pt1.executeUpdate();				
	 					System.out.println(rowsEffected + " records inserted!" );*/
	 		        }
	 		        
	 		        
	 		        
	 		        
	 		        
	 		        
	 		        
	              
	           
		
		return null;
		 
		
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) {
		try(Connection con= 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root")){
			System.out.println("Connected!");
			
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverVersion());
			
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			
			System.out.println(userName + "   userName" );
			System.out.println(password + "   password" );
			
			
			
			PreparedStatement pt = con.prepareStatement("INSERT INTO user values(?,?)");
			User user=new User(userName,password);
			pt.setString(1, user.getUsername());
			pt.setString(2, user.getPassword());
			
			
			int rowsEffected = pt.executeUpdate();
			
			System.out.println(rowsEffected + " records inserted!" );
			
			request.getRequestDispatcher("userhome.jsp").forward(request,response);
						
			PreparedStatement pt2 = con.prepareStatement("SELECT * FROM user");
			ResultSet rs = pt2.executeQuery();
			while(rs.next()) {
				System.out.println(
						rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3)
						);
			}}
			catch(SQLException | ServletException | IOException exception) {
				System.out.println(exception.getMessage());}
		
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

	private String trackloan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(Connection con= 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root")){
			System.out.println("Connected!");
			
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverVersion());
			
			String applno = request.getParameter("applno");
			
			
			System.out.println("Fetching data of application" );
		
		PreparedStatement pt2 = con.prepareStatement("select* ,if(status!='Approved','true','false')from loanInfo where applno(?) ");
		ResultSet rs = pt2.executeQuery();
		while(rs.next()) {
			
			
		}
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("editloanui.jsp");
	        requestDispatcher.forward(request, response);}
		catch(SQLException exception) {
			System.out.println(exception.getMessage());}
	
		
		return null;
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to trackloan page */
		return null;
	}
}