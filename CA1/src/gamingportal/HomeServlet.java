package gamingportal;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		String gamerTag = request.getParameter("gamerTag");
		
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
		if(creditsAdd != null)
			{
			int creditsPlus = Integer.parseInt(creditsAdd);

			PreparedStatement addCredits = connection.prepareStatement(
					"UPDATE players SET credits = credits + ? WHERE gamerTag = ?");
			addCredits.setInt(1, creditsPlus);
			addCredits.setString(2, gamerTag);
			int rows = addCredits.executeUpdate();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Response Page</title></head><body> Hello User. "
					+ "Got it:.</br><h1> THANK YOU </h1> </body><html>");
			}			
		else if(creditsRemove != null)
		{
			int creditsMinus = Integer.parseInt(creditsRemove);

			PreparedStatement removeCredits = connection.prepareStatement(
					"UPDATE players SET credits = credits - ? WHERE gamerTag = ?");
			removeCredits.setInt(1, creditsMinus);
			removeCredits.setString(2, gamerTag);
			int rows = removeCredits.executeUpdate();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Response Page</title></head><body> Hello User. "
					+ "Got it:.</br><h1> THANK YOU </h1> </body><html>");
		}

	
					
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	
	}

}
