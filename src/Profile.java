import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class Profile implements SessionAware
{
	private String username;
	private String email;
	private String fullName;
	private Map<String, Object> session;
	
	public String getUsername()
	{
		return username;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getFullName()
	{
		return fullName;
	}
	
	public void setSession(Map map) 
    {
		session = map;
	}
	
	public String viewProfile()
	{
		Object currentUser = session.get("currentUser");
		if(currentUser == null)
		{
			return "login";
		}
		
		String currentUsername = currentUser.toString();
		
		Connection connection = null;
		PreparedStatement profile = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/bidheaven?serverTimezone=UTC",
	                "root", "rootroot1");
			
            String sql = "SELECT username, email, full_name FROM users WHERE username = ?";
            profile = connection.prepareStatement(sql);
            profile.setString(1, currentUsername);
            
            rs = profile.executeQuery();
            if(rs.next())
            {
            this.username = rs.getString("username");
            this.email = rs.getString("email");
            this.fullName = rs.getString("full_name");
            return "success";
            }
            else
            {
            	return "error";
            }
		}catch(SQLException e)
		{
			e.printStackTrace();
			return "error";
		}
	}
	
}
