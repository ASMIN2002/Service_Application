package com.asmin.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.jdbc.Blob;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/reg")
public class MyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String email = req.getParameter("uemail");
		String pass = req.getParameter("upwd");	
		

		resp.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/JAVA?allowPublicKeyRetrieval=true&useSSL=false", "root", "Asmin@2002");

			PreparedStatement ps = connection.prepareStatement("insert into reg values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			
			
			try {
				int count = ps.executeUpdate();

				if (count > 0) {
					HttpSession sa=req.getSession();
					sa.setAttribute("name", name);
					sa.setAttribute("email", email);
					sa.setAttribute("pass", pass);
					
					
					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.include(req, resp);
				} else {
					RequestDispatcher rd = req.getRequestDispatcher("already.html");
					rd.include(req, resp);
				}
			} catch (Exception e) {
				RequestDispatcher rd = req.getRequestDispatcher("already.html");
				rd.include(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
