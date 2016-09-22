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

		if (conta.getSaldo().compareTo(valorSaque) >= 0) {

			conta.setSaldo(saldoApos.subtract(valorSaque));

			new ContaDao().updateSaldo(conta, conta.getSaldo());

		} else if (valorSaque.compareTo(conta.getSaldo()) < 0) {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque! Seu saldo é de R$ " + conta.getSaldo(),
					"Atenção", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {

			conta.setSaldo(saldoApos.subtract(valorSaque));

			new ContaDao().updateSaldo(conta, conta.getSaldo());
		}
		return true;

	}

	@Override
	public boolean transferencia(Conta conta, Conta contaRecebeTransf, BigDecimal valorTransf) {

		contaRecebeTransf = new ContaDao().getConta(contaRecebeTransf.getAgencia(), contaRecebeTransf.getNumeroConta(),
				contaRecebeTransf.getNome());
		BigDecimal contaRecebeSaldoApos = contaRecebeTransf.getSaldo();

		conta = new ContaDao().getConta(conta.getAgencia(), conta.getNumeroConta(), conta.getNome());
		BigDecimal contaSaldoApos = conta.getSaldo();

		if (conta.getSaldo().compareTo(valorTransf) >= 0) {
			conta.setSaldo(contaSaldoApos.subtract(valorTransf));
			contaRecebeTransf.setSaldo(contaRecebeSaldoApos.add(valorTransf));

			new ContaDao().updateSaldo(conta, conta.getSaldo());
			new ContaDao().updateSaldo(contaRecebeTransf, contaRecebeTransf.getSaldo());
			return true;
		} else if (valorTransf.compareTo(conta.getSaldo()) < 0) {
			JOptionPane.showMessageDialog(null,
					"Saldo insuficiente para transferência! Seu saldo é de R$ " + conta.getSaldo(), "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return false;

	}

	@Override
	public boolean pagamento(Conta conta, BigDecimal valorPagam, String codigoDeBarras) {

		conta = new ContaDao().getConta(conta.getAgencia(), conta.getNumeroConta(), conta.getNome());
		BigDecimal saldoApos = conta.getSaldo();

		if (conta.getSaldo().compareTo(valorPagam) >= 0) {

			conta.setSaldo(saldoApos.subtract(valorPagam));

			new ContaDao().updateSaldo(conta, conta.getSaldo());

			return true;

		} else if (valorPagam.compareTo(conta.getSaldo()) < 0) {
			JOptionPane.showMessageDialog(null,
					"Saldo insuficiente para pagamento! Seu saldo é de R$ " + conta.getSaldo(), "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return false;

	}

	@Override
	public void finalizarConta(Conta conta) {

	}

}
