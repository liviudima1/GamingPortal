package gamingportal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String creditsAdd = request.getParameter("creditsAdd");
		
		String creditsRemove = request.getParameter("creditsRemove");
		
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingportal?serverTimezone=UTC","root", "rootroot1");
			
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		try {
			PreparedStatement addCredits = connection.prepareStatement(
					"SELECT * FROM players WHERE gamerTag=? and password=?");
			addCredits.setString(1, credits);
			checkUser.setString(2, password);
			
			ResultSet rs = checkUser.executeQuery();
			
			if(rs.next())
			{
				response.sendRedirect("home.html");
			}
					
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	
	}

}
