import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class MakeBid implements SessionAware {
	
	private int itemId;
	private double bidAmount;
	
	private Map<String, Object> session;
	
	public int getItemId()
	{
		return itemId;
	}
	
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	
	public double getBidAmount()
	{
		return bidAmount;
	}
	
	public void setBidAmount(double bidAmount)
	{
		this.bidAmount = bidAmount;
	}
	
	@Override
	public void setSession(Map map) 
	{
		session = map;
	}
	
	public String makeBid()
	{
		Object currentUser = session.get("currentUser");
		if(currentUser == null)
		{
			return "login";
		}
		String bidderUsername = currentUser.toString();
		
		Connection connection = null;
		PreparedStatement makeBid = null;
		
		try {
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/bidheaven?serverTimezone=UTC",
	                "root", "rootroot1");
			
			String sql = "INSERT INTO bids (item_id, bidder_username, bid_amount) " + 
		             "VALUES (?, ?, ?)";
			
			makeBid = connection.prepareStatement(sql);
			makeBid.setInt(1, itemId);
			makeBid.setString(2, bidderUsername);
			makeBid.setDouble(3, bidAmount);
			
			int rows = makeBid.executeUpdate();
			
			if(rows > 0)
			{
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
