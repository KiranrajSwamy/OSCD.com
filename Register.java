



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Servlet implementation class GetUserInfo
 */
//@WebServlet("")

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();			
		try
		{
	       //HttpSession session=request.getSession(false);			

    /*           DB Db=new DB();
	       Db.loadDriver();
	       Db.getConnection();
    */
                    DatabaseHandler DB=new DatabaseHandler();
                    
               String uname=request.getParameter("uname");
		   String lname=request.getParameter("lname");  
		   String email=request.getParameter("email");        
		//   String lname=request.getParameter("lname");
		   String pass=request.getParameter("pass");
		   String phone_no=request.getParameter("phone");
		   String address=request.getParameter("address");        
		   //String secAns=request.getParameter("ans");        
		   ResultSet rs1=DB.select("select * from users where email='"+email+"'");
   	                       
                   if(rs1.next())
			{
                            
//   				JOptionPane.showMessageDialog(null,"lname already exist");		    
 //  				response.sendRedirect("JspPages/login.jsp");
   			
                            
                            out.println ("<script type=\"text/javascript\">");
   				out.println("alert('Login-name already exist!');");
   				out.println("location='login.html'; ");
   				out.println("</script>");
			}
			else
			{
				int id=DB.getMaxId();
       // out.println("here"+id);
	    	
                                int rs=DB.insertRecord(id+1,uname,lname,email,pass,address,phone_no);
	        			out.println ("<script type=\"text/javascript\">");
	   				out.println("alert('Sign-up Successfull! plz login!');");
	   				out.println("location='login.html'; ");
	   				out.println("</script>");
          
                           if(rs>0)
				{
//				   JOptionPane.showMessageDialog(null,"insert succes");		    
//				   response.sendRedirect("JspPages/login.jsp");
	   				out.println ("<script type=\"text/javascript\">");
	   				out.println("alert('Sign-up Successfull! plz login!');");
	   				out.println("location='login.html'; ");
	   				out.println("</script>");

				}
			
			   else
			   {
//				   System.out.println("hello");
//				   JOptionPane.showMessageDialog(null,"insertion fail");		    
//				   response.sendRedirect("JspPages/login.jsp");
	   				out.println ("<script type=\"text/javascript\">");
	   				out.println("alert('Sign-up Failed!');");
	   				out.println("location='login.html'; ");
	   				out.println("</script>");
			   
                           }
			}

			}

               
		catch(Exception e)
		{
	//		JOptionPane.showMessageDialog(null,"insertion fail");		    
	//		response.sendRedirect("JspPages/login.jsp");
				out.println ("<script type=\"text/javascript\">");
				out.println("(alert('Sign-up Failed!');");
				out.println("location='login.html'; ");
				out.println("</script>");
e.printStackTrace();
               }

               
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

        
        
        
}


