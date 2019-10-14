
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DTHServlet
 */
@WebServlet("/DTHServlet")
public class DTHServlet extends HttpServlet {
	static Connection conn;
	static PreparedStatement ps;
	String driverName="oracle.jdbc.driver.OracleDriver";
	String DB_URL="jdbc:oracle:thin:@localhost:1521:xe";
	String DB_USER="system";
	String DB_PASS="12345";
	String query="insert into setupbox values(?,?,?,?,?,?,?,?,?,?,?)";
	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
   		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
			String type=request.getParameter("stype");
			String features=request.getParameter("features");
			float length=Float.parseFloat(request.getParameter("length"));
			float breadth=Float.parseFloat(request.getParameter("breadth"));
			float width=Float.parseFloat(request.getParameter("width"));
			float price=Float.parseFloat(request.getParameter("price"));
			float icharge=Float.parseFloat(request.getParameter("icharge"));
			float ucharge=Float.parseFloat(request.getParameter("ucharge"));
			String discount=request.getParameter("discount");
			String btype=request.getParameter("btype");
			String refund=request.getParameter("deposit");
			String hidden1=request.getParameter("register");
			if(hidden1.equals("create"))
			{
				ps = conn.prepareStatement(query);
				ps.setString(1, type);
				ps.setString(2, features);
				ps.setFloat(3, length);
				ps.setFloat(4, breadth);
				ps.setFloat(5, width);
				ps.setFloat(6, price);
				ps.setFloat(7, icharge);
				ps.setFloat(8, ucharge);
				ps.setString(9, discount);
				ps.setString(10, btype);
				ps.setString(11, refund);
				int i=ps.executeUpdate();
				System.out.println(i+" row updated");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
