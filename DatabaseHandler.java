
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


class DatabaseHandler {
    Connection con;
    public DatabaseHandler() throws Exception{
Class.forName("com.mysql.jdbc.Driver");

        con=DriverManager.getConnection("jdbc:mysql://localhost/oscd","root","");
			
    }

  public ResultSet select(String query)throws Exception{
    
      Statement st=con.createStatement();
      ResultSet res=st.executeQuery(query);
      return res;
    }
  
public int getMaxId() throws Exception{
Statement st=con.createStatement();
ResultSet res=st.executeQuery("select * from users");
int lastid=0;

while(res.next()){
res.next();
lastid++;

}
    System.out.println("  last id "+lastid);
return lastid+21;
}
 int insertRecord(int id,String name,String lname,String  emial,String pass,String add,String ph) throws Exception{
 
     PreparedStatement pst=con.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
     pst.setInt(1,id);
     pst.setString(2,name);
     pst.setString(3,lname);
    pst.setString(4, emial);
    pst.setString(5,pass);
     pst.setString(7,ph);
     pst.setString(6,add);
 if(pst.execute())
 return 0;
 
 return 1;
     }

 int insertProd(int id,String name,String brand,int price,int qty,String desc,String image) throws Exception
 {
 
     PreparedStatement pst=con.prepareStatement("insert into product values(?,?,?,?,?,?,?)");
     pst.setInt(1,id);
     pst.setString(2,name);
     pst.setString(3,brand);
    pst.setInt(4,price);
      pst.setInt(5,qty);
     pst.setString(6,desc);
     pst.setString(7,image);

     if(pst.execute())
 return 0;
 return 1;
      
 }
  int insertSeller(int id,String sname,String  email,String pass,String add,String ph,String legalname,String company) throws Exception
  {
      PreparedStatement pst=con.prepareStatement("insert into seller values(?,?,?,?,?,?,?,?)");
     pst.setInt(1,id);
     pst.setString(2,sname);
     //pst.setString(3,lname);
    pst.setString(3, email);
    pst.setString(4,pass);
     pst.setString(5,add);
     pst.setString(6,ph);
     pst.setString(7,legalname);
     pst.setString(8,company);
 if(pst.execute())
 return 0;
  return 1;
 }

public ResultSet checkLogin(String lname,String password) throws SQLException{
               Statement st=con.createStatement();
               ResultSet rs=st.executeQuery("select * from users where email='"+lname+"' and pass='"+password+"';");
int i=0;
return rs;

     }


public ResultSet checkLoginSeller(String email,String password) throws SQLException{
               Statement st=con.createStatement();
               ResultSet rs=st.executeQuery("select * from seller where email='"+email+"' and pass='"+password+"';");
int i=0;
return rs;



}
}
