package coletanea.codigos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String url = "jdbc:mysql://localhost/coletanea";
	private String user = "root";
	private String pass = "";

	public Connection getConnection(){
		
		try{
			return DriverManager.getConnection(url, user, pass);
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar ao banco!");
		}
	}
	
}
