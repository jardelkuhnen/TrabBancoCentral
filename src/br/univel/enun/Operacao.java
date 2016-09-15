package br.univel.enun;

public enum Operacao {

	SAQUE(0, "saque"), DEPOSITO(1, "dep�sito"), TRANSFERENCIA(2, "transfer�ncia"), PAGAMENTO(3, "pagamento");

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
