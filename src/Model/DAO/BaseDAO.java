package Model.DAO;

import java.sql.*;

public abstract class BaseDAO {
	Connection conn = null;
	
	String url = "jdbc:postgresql://localhost:5432/Prime";
	String user = "postgres";
	String senha = "30317512";
	
	public Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, senha);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} else 
			return conn;
	}
}
