package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CriaBaseDeDadosLivraria {
	
	public static void main ( String[] args) throws Exception {
		String stringDeConexao = "jdbc:mysql://localhost:3306";
		String usuario = "root";
		String senha = "12345678";
		
		System.out.println("Abrindo conexao...");
		Connection conexao =
				DriverManager.getConnection(stringDeConexao, usuario, senha);
		System.out.println("Apagando a base de dados livraria...");
		String sql = "DROP DATABASE IF EXISTS livraria";
				PreparedStatement comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();
		
		System.out.println("Criando a base de dados livraria");
		sql = "CREATE DATABASE livraria";
		comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();
		
		System.out.println("Fechando conexao...");
		conexao.close();
	}

}
