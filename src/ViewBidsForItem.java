import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewBidsForItem {
	private int itemId;
	private ArrayList<String> bids;
	
	public int getItemId()
	{
		return itemId;
	}
	
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	
	public ArrayList<String> getBids()
	{
		return bids;
	}
	
	public String viewBidsForItem()
	{
		bids = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement viewBids = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/bidheaven?serverTimezone=UTC",
	                "root", "rootroot1");
			String sql = "SELECT bidder_username, bid_amount FROM bids WHERE item_id = ?";
			viewBids = connection.prepareStatement(sql);
			viewBids.setInt(1, itemId);
			
			rs = viewBids.executeQuery();
			
			while(rs.next())
			{
				String bidder = rs.getString("bidder_username");
				double amount = rs.getDouble("bid_amount");
				
				String row = "Bidder: " + bidder + ", bid ammount: " + amount;
				bids.add(row);
			}
			return "success";
		} catch(SQLException e)
		{
			e.printStackTrace();
			return "error";
		}
	}
}
