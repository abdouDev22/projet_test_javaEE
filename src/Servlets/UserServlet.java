package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.ConnexionSingleton;
import base.User;
import dao.UserDao;

public class UserServlet extends HttpServlet {
	UserDao userDao= new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page=req.getParameter("page");
		String id1=req.getParameter("id");
		int id2=Integer.valueOf(id1);
		if(page==null) {
			page="list";
		}
		if(page.equals("edit")) {
			User u=userDao.getByID(id2);
			req.setAttribute("user", u);

			this.getServletContext().getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
		}else if(page.equals("update")) {



			User u=userDao.getByID(id2);
			req.setAttribute("user", u);
				
this.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
		}else if(page.equals("supprimer")) {
			userDao.delete(id2);
		}
		else{
			List<User> uers= userDao.getAll();
					req.setAttribute("users", uers);
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String page=req.getParameter("page");
		String  nom= req.getParameter("nom");
		String  prenom= req.getParameter("prenom");
		String  login= req.getParameter("login");
		String  mdp= req.getParameter("password");
		
		if(page==null) {
			String  role="user";
		 	User u = new User(nom, prenom, login, mdp, role);
		 	userDao.ajouter(u);
		
		}else {

				String role=req.getParameter("role");
				String id=req.getParameter("id");
				int id1=Integer.valueOf(id);
                User user= new User(id1, nom, prenom, login, mdp, role);
				userDao.update(user);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
				
			}


	}







}


