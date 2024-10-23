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

@WebServlet("/del")
public class Delete extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		HttpSession hs = req.getSession();
		String rname=(String)hs.getAttribute("name");
		
		String query = "delete from "+rname+" where course=?";
		
		
		String java = req.getParameter("JAVA");
		String oracle = req.getParameter("ORACLE");
		String html = req.getParameter("HTML");
		String css = req.getParameter("CSS");
		String projects = req.getParameter("PROJECTS");
		String mock = req.getParameter("MOCK");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/JAVA?allowPublicKeyRetrieval=true&useSSL=false", "root", "Asmin@2002");

			PreparedStatement ps = con.prepareStatement(query);
			
			if(java!=null){
				ps.setString(1, "JAVA");
				int count=ps.executeUpdate();
				if(count>0) {
					RequestDispatcher rd = req.getRequestDispatcher("online.html");
					rd.include(req, resp);
				}
			}else if(oracle!=null){
				ps.setString(1, "ORACLE");
				int count=ps.executeUpdate();
				if(count>0) {
					RequestDispatcher rd = req.getRequestDispatcher("online.html");
					rd.include(req, resp);
				}
			}else if(html!=null){
				ps.setString(1, "HTML");
				int count=ps.executeUpdate();
				if(count>0) {
					RequestDispatcher rd = req.getRequestDispatcher("online.html");
					rd.include(req, resp);
				}
			}else if(css!=null){
				ps.setString(1, "CSS");
				int count=ps.executeUpdate();
				if(count>0) {
					RequestDispatcher rd = req.getRequestDispatcher("online.html");
					rd.include(req, resp);
				}
			}else if(projects!=null){
				ps.setString(1, "PROJECTS");
				int count=ps.executeUpdate();
				if(count>0) {
					RequestDispatcher rd = req.getRequestDispatcher("online.html");
					rd.include(req, resp);
				}
			}else if(mock!=null){
				ps.setString(1, "MOCK");
				int count=ps.executeUpdate();
				if(count>0) {
					RequestDispatcher rd = req.getRequestDispatcher("online.html");
					rd.include(req, resp);
				}
			}


			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
