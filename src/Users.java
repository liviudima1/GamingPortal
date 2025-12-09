import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users {

	private ArrayList<String> usernames;
	
	public ArrayList<String> getUsernames()
	{
		return usernames;
	}
	
	public String viewAllUsers()
	{
		Connection connection = null;
		PreparedStatement viewUsers = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/bidheaven?serverTimezone=UTC",
	                "root", "rootroot1");
			
			String sql = "SELECT username FROM users";
			viewUsers = connection.prepareStatement(sql);
			rs = viewUsers.executeQuery();
			
			usernames = new ArrayList<String>();
			
			while(rs.next())
			{
				usernames.add(rs.getString("username"));
			}
			return "success";
		}catch(SQLException e) {
			e.printStackTrace();
			return "error";
		}
	}
}

