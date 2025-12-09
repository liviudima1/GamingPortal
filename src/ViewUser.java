import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewUser 
{
	private String username;
	private String email;
	private String fullName;
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getUsername()
	{
		return username;
	}
	public String getEmail()
	{
		return email;
	}
	public  String getFullName()
	{
		return fullName;
	}
	
	public String viewUser()
	{
		Connection connection = null;
		PreparedStatement viewUser = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/bidheaven?serverTimezone=UTC",
	                "root", "rootroot1");
			String sql = "SELECT username, email, full_name FROM users WHERE username = ?";
			viewUser = connection.prepareStatement(sql);
			viewUser.setString(1, username);
			
			rs = viewUser.executeQuery();
			
			if (rs.next()) {
                this.username = rs.getString("username");
                this.email = rs.getString("email");
                this.fullName = rs.getString("full_name");
                return "success";
            } else 
            {
                return "error";
            }

        } catch (SQLException e) 
		{
            e.printStackTrace();
            return "error";
		
		}
	}
}
