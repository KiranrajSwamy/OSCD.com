


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = null;
		   HttpSession session=request.getSession(true);	
		    
		// TODO Auto-generated method stub
		try
		{
		
		 
	    response.setContentType("text/html");

	    out = response.getWriter();
	    String email=request.getParameter("email");
	    String password=request.getParameter("pass");        
	 
             
		DatabaseHandler Db=new DatabaseHandler();
                
       ResultSet rs=Db.checkLogin(email, password);
                  out.println(" email "+email);
                
            if(!rs.next())
		{
				out.println ("<script type=\"text/javascript\">");
				out.println("alert('Invalid Password or Login Name!');");
	//			out.println("location='JspPages/login.jsp'; ");
				out.println("</script>");
		}
		else
		{

			
		
			session.setAttribute("uid",rs.getInt("userid"));
			session.setAttribute("welcome",rs.getString("email"));
			session.setAttribute("email",rs.getString("email"));
	    	
                        response.sendRedirect("home.jsp");
		
                }
	}
	catch(Exception e)
	{		
			out.println ("<script type=\"text/javascript\">");
			out.println("alert('exception Invalid Password or Login Name!');");
			out.println("location='login.html'; ");
			out.println("</script>");
	   
			/*
		session.setAttribute("loginError","Incorrect password or login name");
	    response.sendRedirect("JspPages/login.jsp");
		*/
	}
		
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
