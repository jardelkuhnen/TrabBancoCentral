package br.univel.interfacee;

import java.math.BigDecimal;

import br.univel.model.Conta;

public interface ContaMethods {

	public void deposito(Conta conta, BigDecimal valorDeposito);

	public boolean saque(Conta conta, BigDecimal valorSaque, String senhaInformada);

	public void transferencia(Conta conta, Conta contaRecebeTransf, BigDecimal valorTransf);

	public boolean pagamento(Conta conta, BigDecimal valorPagam, String codigoDeBarras);

	public void finalizarConta(Conta conta);

}
