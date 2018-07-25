package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CriandoTabelaEditora {

	public static void main(String[] args) throws Exception {
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();
		
		System.out.println("Criando a tabela Editora...");
		String sql = 
		"CREATE TABLE Editora (" +
		"id BIGINT NOT NULL AUTO_INCREMENT ," +
		"nome VARCHAR (255) NOT NULL," +
		"email VARCHAR (255) NOT NULL," +
		"PRIMARY KEY (id)" +
		")" +
		"ENGINE = InnoDB";
		
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();
		
		System.out.println("Fechando conexao...");
		comando.close();
		
	}

}
