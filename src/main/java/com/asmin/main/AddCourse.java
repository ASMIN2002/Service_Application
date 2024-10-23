package com.asmin.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/course")
public class AddCourse extends HttpServlet {

	
	PreparedStatement ps;
	Connection connection;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		int i = 0;

		resp.setContentType("text/html");
		
		HttpSession sa = req.getSession();
		String rname = (String)sa.getAttribute("name");
		
		String query="insert into "+rname+" values(?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/JAVA?allowPublicKeyRetrieval=true&useSSL=false", "root", "Asmin@2002");

			while (i <= 0) {
				
				

				String java = req.getParameter("java");
				String oracle = req.getParameter("oracle");
				String html = req.getParameter("html");
				String css = req.getParameter("css");
				String projects = req.getParameter("projects");
				String mock = req.getParameter("mock");

				if (java != null) {
					ps = connection.prepareStatement(query);
					ps.setString(1, rname);
					ps.setString(2, java);
					try {
						int count = ps.executeUpdate();
						if (count > 0) {
							RequestDispatcher rd = req.getRequestDispatcher("success.html");
							rd.include(req, resp);
						}
					} catch (Exception e) {
						RequestDispatcher rd = req.getRequestDispatcher("error.html");
						rd.include(req, resp);
						java = null;
					}
				}else if (oracle != null) {
					ps = connection.prepareStatement(query);
					ps.setString(1, rname);
					ps.setString(2, oracle);
					try {
						int count = ps.executeUpdate();
						if (count > 0) {
							RequestDispatcher rd = req.getRequestDispatcher("success.html");
							rd.include(req, resp);
						}
					} catch (Exception e) {
						RequestDispatcher rd = req.getRequestDispatcher("error.html");
						rd.include(req, resp);
						oracle = null;
					}
				} else if (html != null) {
					ps = connection.prepareStatement(query);
					ps.setString(1, rname);
					ps.setString(2, html);
					try {
						int count = ps.executeUpdate();
						if (count > 0) {
							RequestDispatcher rd = req.getRequestDispatcher("success.html");
							rd.include(req, resp);
						}
					} catch (Exception e) {
						RequestDispatcher rd = req.getRequestDispatcher("error.html");
						rd.include(req, resp);
						html = null;
					}
				} else if (css != null) {
					ps = connection.prepareStatement(query);
					ps.setString(1, rname);
					ps.setString(2, css);
					try {
						int count = ps.executeUpdate();
						if (count > 0) {
							RequestDispatcher rd = req.getRequestDispatcher("success.html");
							rd.include(req, resp);
						}
					} catch (Exception e) {
						RequestDispatcher rd = req.getRequestDispatcher("error.html");
						rd.include(req, resp);
						css = null;
					}
				} else if (projects != null) {
					ps = connection.prepareStatement(query);
					ps.setString(1, rname);
					ps.setString(2, projects);
					
					try {
						
						int count = ps.executeUpdate();
						if (count > 0){
							RequestDispatcher rd = req.getRequestDispatcher("success.html");
							rd.include(req, resp);
						}
						
					} catch (Exception e){
						RequestDispatcher rd = req.getRequestDispatcher("error.html");
						rd.include(req, resp);
						projects = null;
					}
					
				} else if (mock != null){
					ps = connection.prepareStatement(query);
					ps.setString(1, rname);
					ps.setString(2, mock);
					try{
						int count = ps.executeUpdate();
						if(count > 0){
							RequestDispatcher rd = req.getRequestDispatcher("success.html");
							rd.include(req, resp);
						}
					}catch (Exception e) {
						RequestDispatcher rd = req.getRequestDispatcher("error.html");
						rd.include(req, resp);
						mock = null;
					}
				}
				i++;
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
