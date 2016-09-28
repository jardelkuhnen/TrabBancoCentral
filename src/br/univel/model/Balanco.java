package br.univel.model;

import java.math.BigDecimal;
import java.util.Date;

public class Balanco {

	private Integer id;
	private String agenca;
	private String conta;
	private String operacao;
	private BigDecimal valor;
	private Date data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgenca() {
		return agenca;
	}

	public void setAgenca(String agenca) {
		this.agenca = agenca;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
