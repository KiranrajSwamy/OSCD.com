



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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class GetUserInfo
 */
//@WebServlet("")

public class insertprod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertprod() {
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
                    
               String name=request.getParameter("name");
		       String brand=request.getParameter("brand");     
                   int price = Integer.parseInt(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		   String desc=request.getParameter("desc");
		   String image=request.getParameter("image");        
		
                   int id=DB.getMaxId();
          	
                                int rs=DB.insertProd(id+1,name,brand,price,qty,desc,image);
                    out.println ("<script type=\"text/javascript\">");
	   				out.println("alert('inserted Successfull!!');");
	   				out.println("location='sellerhome.html'; ");
	   				out.println("</script>");
	              
                           if(rs>0)
				{
                                  
	   				out.println ("<script type=\"text/javascript\">");
	   				out.println("alert('inserted Successfull!!');");
	   				out.println("location='sellerhome.html'; ");
	   				out.println("</script>");

				}
                            else 
                           {
                               out.println ("<script type=\"text/javascript\">");
                               out.println("alert('failed!');");
                               out.println("location='addproduct.html'; ");
                               out.println("</script>");
                          }
			} catch (Exception ex) 
                        {
                            
                            out.println ("<script type=\"text/javascript\">");
                               out.println("alert('failed!');");
                               out.println("location='addproduct.html'; ");
                               out.println("</script>");
                        }

	}

               
		
        
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}


