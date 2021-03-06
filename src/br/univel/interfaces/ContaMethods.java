package br.univel.interfaces;

import java.math.BigDecimal;

import br.univel.model.Conta;

public interface ContaMethods {

	public boolean saque(Conta conta, BigDecimal valorSaque, String senhaInformada);

	public boolean transferencia(Conta conta, Conta contaRecebeTransf, BigDecimal valorTransf);

	public boolean pagamento(Conta conta, BigDecimal valorPagam, String codigoDeBarras);

	public void finalizarConta(Conta conta);

	public void deposito(Conta conta, BigDecimal valorDeposito);

}
