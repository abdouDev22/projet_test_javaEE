package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnexionSingleton {
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost/iad";
			String log="root";
			String md="";
			 conn = DriverManager.getConnection(url,log,md);
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
