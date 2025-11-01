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
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String gamerTag = request.getParameter("gamerTag");
		
		String password = request.getParameter("password");
		
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingportal?serverTimezone=UTC","root", "rootroot1");
			
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		try {
			PreparedStatement checkUser = connection.prepareStatement(
					"select * from gamingportal where name=? and password=?");
			checkUser.setString(1, gamerTag);
			checkUser.setString(2, password);
			
			ResultSet rs = checkUser.executeQuery();
			
			if(rs.next())
			{
				HttpSession session = request.getSession();
				response.sendRedirect("home.html");
			}
					
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}
}
