package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsereLivro {
public static void main(String[] args) throws Exception {
	System.out.println("Abrindo conexao...");
	Connection conexao = ConnectionFactory.createConnection();
	
	Scanner entrada = new Scanner(System.in);
	Livro e = new Livro();
	
	System.out.println("Digite o nome do livro : ");
	e.setTitulo(entrada.nextLine());
	
	System.out.println("Digite o preco do livro: ");
	e.setPreco(entrada.nextDouble());
	
	entrada.close();
	
	String sql = "INSERT INTO Livro (titulo, preco) VALUES(?, ? ) ";
	
	PreparedStatement comando = conexao.prepareStatement(sql, 
		Statement.RETURN_GENERATED_KEYS	);
	comando.setString(1,  e.getTitulo());
	comando.setDouble(2,  e.getPreco());
	
	System.out.println("Executando comando...");
	comando.execute();
	
	System.out.println("Recuperando o ID gerado pelo SGBD...");
	ResultSet generatedKeys = comando.getGeneratedKeys();
	generatedKeys.next();
	e.setId(generatedKeys.getLong(1));
	System.out.println("ID: " + e.getId());
	
	System.out.println("Fechando conexao...");
	conexao.close();
	}
}
