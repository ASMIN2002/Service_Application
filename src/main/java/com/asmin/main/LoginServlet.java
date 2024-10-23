package com.asmin.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String aname = req.getParameter("uname");
		String pass = req.getParameter("upwd");
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/JAVA?allowPublicKeyRetrieval=true&useSSL=false", "root", "Asmin@2002");

			PreparedStatement ps = connection.prepareStatement("select * from reg where uname=? and upwd=?");
			ps.setString(1, aname);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			PrintWriter out = resp.getWriter();

			if (rs.next()) {
				resp.setContentType("text/html");
				HttpSession se = req.getSession();
				se.setAttribute("name", aname);

				String course = (String) se.getAttribute("name");

				String query = "create table " + course + "(name varchar(30),course varchar(20) primary key)";
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root",
						"Asmin@2002");
				
				PreparedStatement ps1 = connection1.prepareStatement(query);
				try {
				ps1.executeUpdate();
				}catch(Exception e) {
					RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
					rd.include(req, resp);
				}
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.include(req, resp);
			} else {
				out.print("<html>");
				out.print("<body style='background-color: black;'>");
				out.print(
						"<h1 style='color:red;text-align:center;align-items:center;margin-top:100px;'>Please Enter Your Correct id and password</h1>");
				out.print(
						"<button style='margin-left: 50%;margin-top:10px;'><a href='login.html' style='text-decoration: none;'>Back</a></button>");
				out.print("</body>");
				out.print("</html>");
			}
			

		} catch (Exception e) {
			System.out.println("Not");
			e.printStackTrace();
		}
	}

}
