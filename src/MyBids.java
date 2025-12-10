import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MyBids implements SessionAware{

	private ArrayList<String> bids;
	private Map<String, Object> session;
	
	public ArrayList<String> getBids()
	{
		return bids;
	}
	
	public void setSession(Map map) 
	{
		session = map;
	}
	
	public String viewMyBids()
	{
		Object currentUser = session.get("currentUser");
		if(currentUser == null)
		{
			return "login";
		}
		
		String bidderUsername = currentUser.toString();
		
		bids = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement viewBids;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/bidheaven?serverTimezone=UTC",
	                "root", "rootroot1");
			String sql = "SELECT items.title, bids.item_id, bids.bid_amount " + 
	                "FROM bids " +
					"JOIN items ON bids.item_id = items.id " +
	                "WHERE bids.bidder_username = ?";
			
			viewBids = connection.prepareStatement(sql);
			viewBids.setString(1, bidderUsername);
			
			rs = viewBids.executeQuery();
			
			while(rs.next())
			{
				String title = rs.getString("title");
				int itemId = rs.getInt("item_id");
				double amount = rs.getDouble("bid_amount");
				
				String row = "Item: " + title + " (ID: " + itemId + "), Your bid: " + amount;
                bids.add(row);
			}
			return "success";

		
		}catch(SQLException e)
		{
			e.printStackTrace();
			return "error";
		}
	}
}
