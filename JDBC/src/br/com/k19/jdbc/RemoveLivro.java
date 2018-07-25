package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RemoveLivro {
	public static void main(String[] args) throws Exception {
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o id do livro que seseja alterar: ");
		Long id = Long.parseLong(entrada.nextLine());
		
		entrada.close();
		
		String sql = "DELETE FROM Livro WHERE id = ? ";
		
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setLong(1, id);
		
		System.out.println("Executando comando...");
		comando.execute();
		
		System.out.println("Fechando conexao..");
		comando.close();
		
	}

}
