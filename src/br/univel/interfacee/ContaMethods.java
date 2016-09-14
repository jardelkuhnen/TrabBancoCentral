package br.univel.interfacee;

import java.math.BigDecimal;

import br.univel.model.Conta;

public interface ContaMethods {

	public void deposito(Conta conta, BigDecimal valorDeposito);

	public void saque(Conta conta, BigDecimal valorSaque, String senhaInformada);

	public void transferencia(Conta conta, Conta contaRecebeTransf, BigDecimal valorTransf);

	public void pagamento(Conta conta, BigDecimal valorPagam);

	public void finalizarConta(Conta conta);

}
