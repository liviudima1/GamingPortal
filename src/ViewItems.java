import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewItems {

	private ArrayList<String> items;
	
	public ArrayList<String> getItems()
	{
		return items;
	}
	
	public String viewItems()
	{
		items = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement viewItems = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/bidheaven?serverTimezone=UTC",
	                "root", "rootroot1");
			String sql = "SELECT id, title, seller_username, starting_price FROM items";
			viewItems = connection.prepareStatement(sql);
			rs = viewItems.executeQuery();
			
			while(rs.next())
			{
				String title = rs.getString("title");
				String seller = rs.getString("seller_username");
				double price = rs.getDouble("starting_price");
				int id = rs.getInt("id");
				
				String row = "[ID: " + id + "] Item: " + title + " Seller Name: " + seller + "Bid Starting Price: " + price;
				items.add(row);
				
		
			}
				return "success";	
		
		}catch(SQLException e)
		{
			e.printStackTrace();
			return "error";
		}
	
	}
}