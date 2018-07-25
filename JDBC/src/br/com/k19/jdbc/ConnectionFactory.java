package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection createConnection() throws SQLException {
		String strinDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "12345678";
		
		return DriverManager.getConnection(strinDeConexao, usuario, senha);

	}

}
