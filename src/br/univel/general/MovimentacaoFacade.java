package br.univel.general;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.dao.ContaDao;
import br.univel.dao.UsuarioDao;
import br.univel.enun.Operacao;
import br.univel.interfacee.ContaMethods;
import br.univel.model.Conta;
import br.univel.view.PadraoCliente;
import br.univel.view.TelaDeposito;

public class MovimentacaoFacade implements ContaMethods {

	ContaDao contaDao = new ContaDao();

	@Override
	public void deposito(Conta conta, BigDecimal valorDeposito) {

		BigDecimal vlrAtualizar = conta.getSaldo().add(valorDeposito);

		conta.setSaldo(vlrAtualizar);
		new ContaDao().updateSaldo(conta, vlrAtualizar);

		PadraoCliente.populaTelaInfConta(conta);

	}

	@Override
	public boolean saque(Conta conta, BigDecimal valorSaque,
			String senhaInformada) {

		conta = new ContaDao().getConta(conta.getAgencia(),
				conta.getNumeroConta(), conta.getNome());
		BigDecimal saldoApos = conta.getSaldo();

		if (conta.getSaldo().compareTo(valorSaque) >= 0) {

			conta.setSaldo(saldoApos.subtract(valorSaque));

			new ContaDao().updateSaldo(conta, conta.getSaldo());

			PadraoCliente.populaTelaInfConta(conta);

		} else {
			JOptionPane.showMessageDialog(
					null,
					"Saldo insuficiente para saque! Seu saldo é de R$ "
							+ conta.getSaldo(), "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;

	}

	@Override
	public boolean transferencia(Conta conta, Conta contaRecebeTransf,
			BigDecimal valorTransf) {

		BigDecimal contaRecebeSaldoApos = contaRecebeTransf.getSaldo();

		System.out.println(contaRecebeSaldoApos);

		conta = new ContaDao().getConta(conta.getAgencia(),
				conta.getNumeroConta(), conta.getNome());

		BigDecimal contaSaldoApos = conta.getSaldo();

		if (conta.getSaldo().compareTo(valorTransf) >= 0) {

			conta.setSaldo(contaSaldoApos.subtract(valorTransf));
			contaRecebeTransf.setSaldo(contaRecebeSaldoApos.add(valorTransf));

			new ContaDao().updateSaldo(conta, conta.getSaldo());
			new ContaDao().updateSaldo(contaRecebeTransf,
					contaRecebeTransf.getSaldo());

			PadraoCliente.populaTelaInfConta(conta);

			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Saldo insuficiente para transferência! Seu saldo é de R$ "
							+ conta.getSaldo(), "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

	}

	public Conta validaContaTransferencia(Conta contaRecebeTransf) {
		/**
		 * Consulta no banco as informacoes da conta a receber transferencia
		 */
		return contaRecebeTransf = new ContaDao()
				.getConta(contaRecebeTransf.getAgencia(),
						contaRecebeTransf.getNumeroConta(),
						contaRecebeTransf.getNome());
	}

	@Override
	public boolean pagamento(Conta conta, BigDecimal valorPagam,
			String codigoDeBarras) {

		conta = new ContaDao().getConta(conta.getAgencia(),
				conta.getNumeroConta(), conta.getNome());
		BigDecimal saldoApos = conta.getSaldo();

		if (conta.getSaldo().compareTo(valorPagam) >= 0) {

			conta.setSaldo(saldoApos.subtract(valorPagam));

			new ContaDao().updateSaldo(conta, conta.getSaldo());

			PadraoCliente.populaTelaInfConta(conta);

			return true;

		} else {
			JOptionPane.showMessageDialog(null,
					"Saldo insuficiente para pagamento! Seu saldo é de R$ "
							+ conta.getSaldo(), "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

	}

	@Override
	public void finalizarConta(Conta conta) {

		conta = new ContaDao().getConta(conta.getAgencia(),
				conta.getNumeroConta(), conta.getNome());

		if (conta.getSaldo().compareTo(new BigDecimal(0.00)) > 0) {

			JOptionPane.showMessageDialog(null, "Sua " + conta.getTipoConta()
					+ " possui saldo de: " + conta.getSaldo()
					+ ". Impossível inativar");

		} else {
			new ContaDao().inativarConta(conta);
			new UsuarioDao().inativarConta(conta);
		}

	}

}
