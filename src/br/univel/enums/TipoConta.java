package br.univel.enums;

public enum TipoConta {

	CC(0, "Conta Corrente"), 
	CP(1, "Conta Poupança"), 
	CE(2, "Conta Eletrônica");

	private String descricao;

	private TipoConta(Integer ordinal, String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String toString() {
		return getDescricao();
	}

}
