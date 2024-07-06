package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.ConnexionSingleton;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login=req.getParameter("login");
		String pwd=req.getParameter("pwd");
		      Connection conn = ConnexionSingleton.getConnection();
		try {	
			PreparedStatement ps = conn.prepareStatement("select * from user where login like ? and mdp like md5(?) ");
			ps.setString(1,login);
			ps.setNString(2, pwd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String nom=rs.getString("nom");
				String prenom=rs.getString("prenom");
				String role=rs.getString("role");
				req.setAttribute("nom", nom);
				req.setAttribute("prenom", prenom);
				if(role.equals("user")) {
					this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(req, resp);
						
				}else {
					this.getServletContext().getRequestDispatcher("/WEB-INF/accueilAdmin.jsp").forward(req, resp);
				}
				}
			
			System.out.println("Ajout avec succes");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
