package br.com.k19.jdbc;

public class Livro {
	private long id;
	private String titulo;
	private double preco;
	private long editora_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public long getEditora_id() {
		return editora_id;
	}
	public void setEditora_id(long editora_id) {
		this.editora_id = editora_id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
