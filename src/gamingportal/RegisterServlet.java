package gamingportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String gamerTag = request.getParameter("gamerTag");
		
		String password = request.getParameter("password");

		String repeatPassword = request.getParameter("confirmPassword");

		
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingportal?serverTimezone=UTC","root", "rootroot1");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		try {
			PreparedStatement registerUser = connection.prepareStatement(
					"INSERT INTO players (gamerTag, password, credits) "
					+ "VALUES (?, ?, 500)"
					);
			registerUser.setString(1, gamerTag);
			registerUser.setString(2, password);
			int rowsUpdated = registerUser.executeUpdate();
			registerUser.close();
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Response Page</title></head><body> Hello User. "
				+ "Got it:.</br><h1> THANK YOU </h1> </body><html>");

}
}
