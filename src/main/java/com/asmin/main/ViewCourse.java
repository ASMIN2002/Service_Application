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

@WebServlet("/re")
public class ViewCourse extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		HttpSession sa = req.getSession();
		String pname= (String)sa.getAttribute("name");
		
		String query="select * from "+pname+" where name=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/JAVA?allowPublicKeyRetrieval=true&useSSL=false", "root", "Asmin@2002");

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pname);

			ResultSet rs = ps.executeQuery();

			out.print("<html>");
			out.print("<body'>");
			out.print("<h1 style='text-align:center;color:white'>YOUR COURSES</h1>");
			out.print("</body>");
			out.print("</html>");

			while (rs.next()) {
				try {
					{
						RequestDispatcher rd = req.getRequestDispatcher("cor.jsp");
						HttpSession hs = req.getSession();
						rd.include(req, resp);
						hs.setAttribute("cors", rs.getString(2));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.print("<html>");
		out.print("<body style='background-color: black'>");
		out.print(
				"<h3 style='display: block;margin: 2px 14px;color: red'>*! If Everything is not Loaded Please Refresh This Page</h3>");
		
		out.print(
				"<button style='display: block;margin: 2px 24px;'><a href='online.html' style='text-decoration:none;'>GO BACK</a></button>");
		out.print("</body>");
		out.print("</html>");

	}
}
