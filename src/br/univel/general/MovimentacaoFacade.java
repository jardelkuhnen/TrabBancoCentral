package br.univel.general;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import br.univel.dao.ContaDao;
import br.univel.interfacee.ContaMethods;
import br.univel.model.Conta;

public class MovimentacaoFacade implements ContaMethods {

	ContaDao contaDao = new ContaDao();

	@Override
	public void deposito(Conta conta, BigDecimal valorDeposito) {

		BigDecimal vlrAtualizar = conta.getSaldo().add(valorDeposito);

		new ContaDao().depositar(conta, vlrAtualizar);

	}

	@Override
	public void saque(Conta conta, BigDecimal valorSaque) {

	}

	@Override
	public void transferencia(Conta conta, Conta contaRecebeTransf, BigDecimal valorTransf) {

	}

	@Override
	public void pagamento(Conta conta, BigDecimal valorPagam) {

	}

	@Override
	public void finalizarConta(Conta conta) {

	}

}
