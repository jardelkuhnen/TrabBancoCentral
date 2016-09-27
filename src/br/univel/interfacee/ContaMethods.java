package br.univel.interfacee;

import java.math.BigDecimal;

import br.univel.model.Conta;
import br.univel.model.Movimentacao;

public interface ContaMethods {

	public boolean saque(Conta conta, BigDecimal valorSaque,
			String senhaInformada);

	public boolean transferencia(Conta conta, Conta contaRecebeTransf,
			BigDecimal valorTransf);

	public boolean pagamento(Conta conta, BigDecimal valorPagam,
			String codigoDeBarras);

	public void finalizarConta(Conta conta);

	public void deposito(Conta conta, BigDecimal valorDeposito);

	public void operacao(Movimentacao operacao);

}
