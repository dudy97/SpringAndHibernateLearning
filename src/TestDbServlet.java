/**
 * Created by admin on 10.11.2018.
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException {
        String user="springstudent";
        String password="springstudent";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        try{
            PrintWriter out = response.getWriter();
            out.print("Connecting to DB"+jdbcUrl);
            Class.forName(driver);
            Connection myCon = DriverManager.getConnection(jdbcUrl,user,password);
            out.print("Connection successful!");
            myCon.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

}
