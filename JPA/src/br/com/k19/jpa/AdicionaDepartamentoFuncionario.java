package br.com.k19.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaDepartamentoFuncionario {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Scanner entrada = new Scanner(System.in);
		
		Funcionario f = new Funcionario();
		System.out.println("Digite  o nome do funcionario: ");
		f.setNome(entrada.nextLine());
		
		Departamento d = new Departamento();
		System.out.println("Digita o nome do departamento: ");
		d.setNome(entrada.nextLine());
		
		entrada.close();
		
		d.getFuncionarios().add(f);
		
		manager.persist(f);
		manager.persist(d);
		
		System.out.println("Funcionario cadastrado com id: " + f.getId());
		System.out.println("Departamento cadastrado com id: " + d.getId());
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		

	}

}
