package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AlteraLivro {
	public static void main(String[] args) throws Exception {
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();
		
		Scanner entrada = new Scanner(System.in);
		Livro l = new Livro ();
		
		System.out.println("Digite o id do livro que deseja alterar: ");
		l.setId(Long.parseLong(entrada.nextLine()));
		
		System.out.println("Digite o novo titulo do livro: ");
		l.setTitulo(entrada.nextLine());
		
		System.out.println("Digite o novo preco do livro: ");
		l.setPreco(entrada.nextDouble());
		
		entrada.close();
		
		String sql = "UPDATE Livro SET titulo = ?, preco = ? WHERE id = ? ";
		
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, l.getTitulo());
		comando.setDouble(2, l.getPreco());
		comando.setLong(3, l.getId());
		
		System.out.println("Executando comando...");
		comando.execute();
		
		System.out.println("Fechando conexao..");
		comando.close();
		
	}

}
