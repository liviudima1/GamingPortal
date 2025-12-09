import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddItem implements SessionAware
{
    private String title;
    private String description;
    private double startingPrice;
    
	private Map<String, Object> session;

	    public String getTitle()
	    {
	    	return title;
	    }
	
	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public double getStartingPrice() {
	        return startingPrice;
	    }
	    public void setStartingPrice(double startingPrice) {
	        this.startingPrice = startingPrice;
	    }
	    
	    public void setSession(Map map) 
	    {
			session = map;
		}
	    
	    
	    public String addItem()
	    {
	    	Object currentUser = session.get("currentUser");
	    	Connection connection = null;
			PreparedStatement addItem = null;
			ResultSet rs = null;
			
			String sellerUsername = currentUser.toString();
	    	
	    	try 
	    	{
	    		
	    	connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/bidheaven?serverTimezone=UTC",
	                "root", "rootroot1");
	    	
	    	String sql = "INSERT INTO items (title, description, starting_price, seller_username)" +
	    				"VALUES (?, ?, ?, ?)";
	    	addItem = connection.prepareStatement(sql);
	    	addItem.setString(1, title);
	    	addItem.setString(2, description);
	    	addItem.setDouble(3, startingPrice);
	    	addItem.setString(4, sellerUsername);
	    	
	    	int rows = addItem.executeUpdate();
	    	
	    	if(rows >0)
	    	{
	    		return "success";
	    	}
	    	else
	    	{
	    		return "error";
	    	}
	    	
	    	}catch (SQLException e)
	    	{
	    		e.printStackTrace();
	    		return "error";
	    	}
	    }
	    
}
