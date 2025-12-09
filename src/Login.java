import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Login implements SessionAware{

	private String username;
	private String password;
	private Map<String, Object> session;
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
        this.username = username;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public void setSession(Map map) 
    {
		session = map;
	}
	
    
    public String login()
    {
    	Connection connection = null;
    	PreparedStatement login = null;
    	ResultSet rs = null;
    	
    	try {
    		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bidheaven?serverTimezone=UTC",
                    "root", "rootroot1");
    	
    		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    		login = connection.prepareStatement(sql);
    		login.setString(1, username);
    		login.setString(2, password);
    		
    		rs = login.executeQuery();
    		
    		if(rs.next())
    		{
    			session.put("currentUser", username);
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
