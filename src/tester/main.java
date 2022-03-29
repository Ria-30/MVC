package tester;
import java.sql.*;
public class main {

	public boolean check(String username, String pass) throws ClassNotFoundException
	{
			String url = "jdbc:mysql://localhost:3306/pat";
			String uname = "root";
			String password = "sanghamitra@30";
			String sql = "select * from usernames where uname = ? and pass = ?" ;
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");//checking if we have the driver or not
			
				Connection con = DriverManager.getConnection(url, uname, password);
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,username);
				st.setString(2,pass);
				ResultSet rs = st.executeQuery();
				if(rs.next()) 
					return true;
						
			}catch(SQLException e) {//looks for any kind of sql exception error
	
				e.printStackTrace();
			}
			return false;
			
	}
}
	
