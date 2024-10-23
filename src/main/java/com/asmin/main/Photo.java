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

@WebServlet("/dpdev")
public class Photo extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		String del = req.getParameter("delete");
	
		if(del!=null) {
			try {
				HttpSession sa=req.getSession();
				String pname = (String)sa.getAttribute("name");
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/JAVA", "root", "Asmin@2002");

				PreparedStatement ps = connection.prepareStatement("delete from reg where uname=?");
				ps.setString(1, pname);
				
				
				try {
					int count = ps.executeUpdate();

					if (count > 0) {		
						
						RequestDispatcher rd = req.getRequestDispatcher("index.html");
						rd.include(req, resp);
					} else {
						System.out.println("JAUNI");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("JAUNI");
					}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
