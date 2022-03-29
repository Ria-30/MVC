package tester;

import java.io.IOException;
//import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/display")
public class display extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/pat";
		String uname = "root";
		String password = "sanghamitra@30";
		String sql = "SELECT * FROM STUDENTS";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");//checking if we have the driver or not
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");

			Connection con = DriverManager.getConnection(url, uname, password);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			out.println("</br><table cellspacing='0' cellpadding='5' border='1'>");
			   out.println("<tr>");
			   out.println("<td><b>ID</b></td>");
			   out.println("<td><b>Name</b></td>");
			   out.println("<td><b>Address</b></td>");
			   out.println("<td><b>Department</b></td>");
			   out.println("</tr>");

			while(rs.next()) {
					out.println("<tr>");
				    out.println("<td>"+rs.getString("id") + "</td><td>"+rs.getString("name") + "</td><td>"+rs.getString("address") + "</td><td>"+rs.getString("department") + "</td>");
				    out.println("</tr>");
			}
			   out.println("</table></br><hr></body></html>");
			   out.println("<form action='logout' method='post'><input type='submit' value='LOGOUT'></form>");
									
		}catch(SQLException e) {//looks for any kind of sql exception error

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
