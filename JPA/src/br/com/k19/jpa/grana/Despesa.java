package br.com.k19.jpa.grana;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Despesa {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private Double valor;
	private Calendar data;
	private String tipo;
	
	@Override
	public String toString() {
		String s = this.nome + " - ";
		s += this.valor + " - ";
		s += this.tipo + " - ";
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat ("dd/MM/yyyy");
		
		s += sdf.format(this.data.getTime());
		
		return s;
	}

}
