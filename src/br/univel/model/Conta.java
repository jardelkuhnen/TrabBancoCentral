package br.univel.model;

import java.math.BigDecimal;

import br.univel.enums.TipoConta;

public class Conta {

	private Integer id;
	private String nome;
	private Integer idade;
	private String cpf;
	private String agencia;
	private String numeroConta;
	private String tipoConta;
	private String usuarioAcesso;
	private String senhaAcesso;
	private String senhaOperacoes;
	private BigDecimal saldo;
	private String situacaoBancaria;

	public Conta() {
	}

	public Conta(Integer id, String nome, Integer idade, String cpf, String agencia, String tipoConta,
			String usuarioAcesso, String senhaAcesso, String senhaOperacoes, String numeroConta, BigDecimal saldo,
			String situacaoBancaria) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.agencia = agencia;
		this.tipoConta = tipoConta;
		this.usuarioAcesso = usuarioAcesso;
		this.senhaAcesso = senhaAcesso;
		this.senhaOperacoes = senhaOperacoes;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.situacaoBancaria = situacaoBancaria;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getUsuarioAcesso() {
		return usuarioAcesso;
	}

	public void setUsuarioAcesso(String usuarioAcesso) {
		this.usuarioAcesso = usuarioAcesso;
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

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getSituacaoBancaria() {
		return situacaoBancaria;
	}

	public void setSituacaoBancaria(String situacaoBancaria) {
		this.situacaoBancaria = situacaoBancaria;
	}

}
