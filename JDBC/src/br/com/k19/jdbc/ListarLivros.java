package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListarLivros {
	
	public static void main(String[] args)throws Exception {
	System.out.println("Abrindo conexao...");
	Connection conexao = ConnectionFactory.createConnection();
	
	String sql = "SELECT * FROM Livro;";
	
	PreparedStatement comando = conexao.prepareStatement(sql);
	
	System.out.println("Executando comando...");
	ResultSet resultado = comando.executeQuery();
	
	List<Livro> lista = new ArrayList<Livro>();
	while (resultado.next()){
		Livro l = new Livro();
		l.setId(resultado.getLong("id"));
		l.setTitulo(resultado.getString("Titulo"));
		l.setPreco(resultado.getDouble("Preco"));
		lista.add(l);
	}
	
	System.out.println("Resultado encontrados: \n");
	for (Livro livro : lista) {
		System.out.println("Id: " + livro.getId());
		System.out.println("Titulo : " + livro.getTitulo());
		System.out.println("Preco: " + livro.getPreco());
		System.out.println("------------------------------");
	}
	
	System.out.println("\n Fechando conexao...");
	conexao.close();
	}
}
