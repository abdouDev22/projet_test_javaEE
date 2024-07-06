package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import base.ConnexionSingleton;
import base.User;

public class UserDao {
	
	Connection con=ConnexionSingleton.getConnection();
	
	
	public void ajouter(User user) {
		try {
			PreparedStatement ps =con.prepareStatement("insert into user (nom,prenom,login,mdp,role) values (?,?,?,md5(?),?)");
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getLogin());
			ps.setString(4,user.getMdp());
			ps.setString(5, user.getRole());
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
		
		
	}
	public void update(User u) {
		try{ PreparedStatement ps = con.prepareStatement("update user set nom=?,prenom=?,login=?,mdp=md5(?) where id=?");
		ps.setString(1, u.getNom());
		ps.setString(2, u.getPrenom());
		ps.setString(3, u.getLogin());
		ps.setString(4,u.getMdp());
		ps.setString(5, u.getRole());
		ps.executeUpdate();
		System.out.println("Update");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try{ PreparedStatement ps = con.prepareStatement("delete from user where id=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Update");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getByID(int id) {
		
		User u=null;
		try{ PreparedStatement ps = con.prepareStatement("select * from user where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id1=rs.getInt("id");
			String nom=rs.getString("nom");
			String prenom=rs.getString("prenom");
			String login=rs.getString("login");
			String mdp=rs.getString("mdp");
			String role=rs.getString("role");
			u=new User(id1, nom, prenom, login, mdp, role);
		}
		
		System.out.println("Update");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public List<User> getAll() {
		List<User> uers= new ArrayList<User>();
		try {
			PreparedStatement ps =con.prepareStatement("select* from user");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nom=rs.getString("nom");
				String prenom=rs.getString("prenom");
				String login=rs.getString("login");
				String mdp=rs.getString("mdp");
				String role=rs.getString("role");
				User u = new User(id, nom, prenom, login, mdp, role);
				uers.add(u);
			}

		}catch(Exception e) {

		}
		return uers;

	}

}
