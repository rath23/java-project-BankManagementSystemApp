package como.bankatm;
import java.sql.*;


public class Conn {

    Connection c;
    Statement s;
    public Conn() {
     try{
       /*  Class.forName(com.mysql.cj.jdbc.Driver);*/
          c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Alpha@1234");
          s = c.createStatement();
      }
      catch (Exception e){
          System.out.println(e);
      }
    }
}
