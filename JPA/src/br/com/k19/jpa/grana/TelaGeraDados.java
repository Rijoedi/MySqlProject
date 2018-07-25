package br.com.k19.jpa.grana;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

public class TelaGeraDados implements Tela{
	
	private Tela anterior;
	
	public TelaGeraDados(Tela anterior) {
		this.anterior = anterior;
	}

	@Override
	public Tela mostra() {
		System.out.println(">>>>" + this.getNome() + "<<<<");
		System.out.println();
		
		System.out.println("Gerando dados...");
		
		EntityManager manager = Grana.getEntityManager();
		
		ReceitaRepositorio receitaRepositorio =
				new ReceitaRepositorio(manager);
		
		DespesaRepositorio despesaRepositorio = 
				new DespesaRepositorio(manager);
		
		manager.getTransaction().begin();
		
		//Receitas//
		
		for(int i = 0; i < 36; i++) {
			Receita receita = new Receita();
			receita.setNome("Salario K19");
			receita.setTipo("Salario");
			receita.setValor(8000.0);
			
		Calendar data = new GregorianCalendar(2014, 0, 10);
		data.add(Calendar.MONTH, i);
		receita.setData(data);
		
		receitaRepositorio.adiciona(receita);
		}
		//FALTA MAIS LINHA DE CODIGO AQUI 
		//PAGINA 98
		
	}

	@Override
	public String getnome() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
