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

		new ContaDao().updateSaldo(conta, vlrAtualizar);

	}

	@Override
	public boolean saque(Conta conta, BigDecimal valorSaque, String senhaInformada) {

		conta = new ContaDao().getConta(conta.getAgencia(), conta.getNumeroConta(), conta.getNome());
		BigDecimal saldoApos = conta.getSaldo();

		if (conta.getSaldo().compareTo(valorSaque) == 1) {

			conta.setSaldo(saldoApos.subtract(valorSaque));

			new ContaDao().updateSaldo(conta, conta.getSaldo());

		} else if (valorSaque.compareTo(conta.getSaldo()) == 1) {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque! Seu saldo � de R$ " + conta.getSaldo(),
					"Aten��o", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {

			conta.setSaldo(saldoApos.subtract(valorSaque));

			new ContaDao().updateSaldo(conta, conta.getSaldo());
		}
		return true;

	}

	@Override
	public void transferencia(Conta conta, Conta contaRecebeTransf, BigDecimal valorTransf) {

	}

	@Override
	public void pagamento(Conta conta, BigDecimal valorPagam, String codigoDeBarras) {

	}

	@Override
	public void finalizarConta(Conta conta) {

	}

}
