package br.univel.model;

import br.univel.interfaces.Coluna;

public class Agencia {

	private Integer id;
	private String nome;
	private String numero;
	private String cidade;

	public Agencia(Integer id, String nome, String numero, String cidade) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.cidade = cidade;
	}

	@Coluna(posicao = -1, nome = "Id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Coluna(posicao = 0, nome = "Nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Coluna(posicao = 1, nome = "Número")
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Coluna(posicao = 2, nome = "Cidade")
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
