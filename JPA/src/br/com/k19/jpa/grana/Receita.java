package br.com.k19.jpa.grana;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.Spring;

@Entity
public class Receita {
	
	@Id
	@GeneratedValue
	private Long id;
	private Spring nome;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Spring getNome() {
		return nome;
	}

	public void setNome(Spring nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
