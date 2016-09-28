package br.univel.enums;

public enum Operacao {

	SAQUE(0, "saque"), 
	DEPOSITO(1, "depósito"), 
	TRANSFERENCIA(2, "transferência"), 
	PAGAMENTO(3, "pagamento");

	private String operacao;

	private Operacao(Integer ordinal, String operacao) {
		this.operacao = operacao;
	}

	public String getOperacao() {
		return operacao;
	}

	public String toString() {
		return getOperacao();
	}

}
