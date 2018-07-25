package br.com.k19.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Consultas {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager manager = factory.createEntityManager();

		// Recuperar a quantidade de revistas//
		String jpql = "SELECT COUNT(x) FROM Revista x";

		TypedQuery<Long> consulta1 = manager.createQuery(jpql, Long.class);
		Long contador = consulta1.getSingleResult();

		System.out.println("Ha " + contador + " revistas. \n");

		// Recuperando a quantidade de revistas com preco acima de 100//
		jpql = "SELECT COUNT(x) FROM Revista x WHERE x.preco > 100";
		TypedQuery<Long> consulta2 = manager.createQuery(jpql, Long.class);
		
		contador = consulta2.getSingleResult();
		System.out.println("Ha " + contador + " revistas com o preco acima de 100. \n");
		
		//somando os precos das revistas//
		
		jpql = "SELECT SUM(x.preco) FROM Revista x ";
		
		TypedQuery<Double> consulta3 = manager.createQuery(jpql, Double.class);
		Double soma = consulta3.getSingleResult();
		
		System.out.println("A soma dos precos das revistas e: " + soma + "\n");
		
		//recuperando o preco da revista mais cara//
		
		jpql = "SELECT MAX(x.preco) FROM Revista x ";
		
		TypedQuery<Double> consulta4 = manager.createQuery(jpql, Double.class);
		
		Double precoMaximo = consulta4.getSingleResult();
		
		System.out.println("O preco da revista mais cara e: " + precoMaximo + "\n" );
		
		//Recuperando a media dos precos das revistas//
		
		jpql = "SELECT AVG(x.preco) FROM Revista x";
		
		TypedQuery<Double> consulta5 = manager.createQuery(jpql, Double.class);
		
		Double media = consulta5.getSingleResult();
		
		System.out.println("A media dos precos das revistas e: " + media + "\n");
		
		//Recuperando todas as revistas//
		
		jpql = "SELECT x FROM Revista x";
		
		TypedQuery<Revista> consulta6 = manager.createQuery(jpql, Revista.class);
		List<Revista> revistas = consulta6.getResultList();
		
		
		System.out.println("Todas as revistas: ");
		
		for(Revista revista : revistas) {
			System.out.println("Id: " + revista.getId());
			System.out.println("Nome:" + revista.getNome());
			System.out.println("Preco: " + revista.getPreco());
			System.out.println();
		}
		
		//Recuperando as revistas com preco acima de 100//
		
		jpql = "SELECT x FROM Revista x WHERE x.preco > 100";
		
		TypedQuery<Revista> consulta7 = manager.createQuery(jpql, Revista.class);
		
		revistas = consulta7.getResultList();
		
		System.out.println("Revistas com preco acima de 100: ");
		
		for(Revista revista : revistas) {
			System.out.println("Id: " + revista.getId());
			System.out.println("Nome: " + revista.getNome());
			System.out.println("Preco: " + revista.getPreco());
		}
		
		manager.close();
		factory.close();

	}

}
