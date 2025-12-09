package gamingportal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register 
{

    private String username;
    private String password;
    private String email;
    private String fullName;

    public String getUsername() 
    {
        return username;
    }
    public void setUsername(String username) {
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

    public String getEmail() 
    {
        return email;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getFullName() 
    {
        return fullName;
    }
    public void setFullName(String fullName) 
    {
        this.fullName = fullName;
    }

    public String register() 
    {
       
    	Connection connection = null;
    	PreparedStatement register = null;
    	
    	try 
    	{
    		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bidheaven?serverTimezone=UTC",
    				"root", "rootroot1");
    		
    		String sql = "INSERT INTO users (username, password, email, full_name) " + 
    		"VALUES (?, ?, ?, ?)";
    		
    		register = connection.prepareStatement(sql);
    		register.setString(1, username);
    		register.setString(2, password);
    		register.setString(3, email);
    		register.setString(4, fullName);
    		
    		int rows = register.executeUpdate();
    		
    		if(rows > 0)
    		{
    			return "success";
    		}
    		else 
    		{
    			return "error";
    		}
    		
    	}catch (SQLException e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
}