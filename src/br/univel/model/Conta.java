package br.univel.model;

import br.univel.enun.TipoConta;

public class Conta {

	private Integer id;
	private String nome;
	private Integer idade;
	private Integer cpf;
	private Integer agencia;
	private Integer numeroConta;
	private TipoConta tipoConta;
	private String senhaAcesso;
	private String senhaOperacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getSenhaAcesso() {
		return senhaAcesso;
	}

	public void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}

	public String getSenhaOperacoes() {
		return senhaOperacoes;
	}

	public void setSenhaOperacoes(String senhaOperacoes) {
		this.senhaOperacoes = senhaOperacoes;
	}

}
