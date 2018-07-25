package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CriaTabelaLivro {

	public static void main(String[] args) throws Exception {
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();
		
		System.out.println("Criando a tabela Livro...");
		String sql = 
		"CREATE TABLE Livro (" +
		"id BIGINT NOT NULL AUTO_INCREMENT ," +
		"titulo VARCHAR (255) NOT NULL," +
		"preco DOUBLE NOT NULL," +
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
