package br.univel.general;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.dao.ContaDao;
import br.univel.dao.UsuarioDao;
import br.univel.enums.Operacao;
import br.univel.interfaces.AtualizacaoDeConta;
import br.univel.interfaces.ContaMethods;
import br.univel.model.Conta;
import br.univel.model.FormatoData;
import br.univel.model.Movimentacao;
import br.univel.view.PadraoCliente;

public class MovimentacaoFacade implements ContaMethods {

	ContaDao contaDao = new ContaDao();

	List<AtualizacaoDeConta> observers = new ArrayList<>();

	Movimentacao movimentacao = new Movimentacao();

	public void addObservers(AtualizacaoDeConta observer) {
		this.observers.add(observer);
	}

	protected void notifyObservers(Conta conta) {

		for (final AtualizacaoDeConta observer : observers) {
			observer.contaAlterada(conta);
		}
	}

	@Override
	public void deposito(Conta conta, BigDecimal valorDeposito) {

		BigDecimal vlrAtualizar = conta.getSaldo().add(valorDeposito);

		conta.setSaldo(vlrAtualizar);
		new ContaDao().updateSaldo(conta, vlrAtualizar);

		movimentacao.setOperacao(Operacao.DEPOSITO.toString());
		movimentacao.setValor(valorDeposito);
		movimentacao.setData(gerarData());

		new ContaDao().insertMovimentacao(movimentacao);

		notifyObservers(conta);

	}

	@Override
	public boolean saque(Conta conta, BigDecimal valorSaque, String senhaInformada) {

		conta = new ContaDao().getConta(conta.getAgencia(), conta.getNumeroConta(), conta.getNome());

		BigDecimal saldoApos = conta.getSaldo();

		if (conta.getSaldo().compareTo(valorSaque) >= 0) {

			saldoApos = saldoApos.subtract(valorSaque);

			conta.setSaldo(new BigDecimal(saldoApos.toString()));

			new ContaDao().updateSaldo(conta, conta.getSaldo());

			movimentacao.setOperacao(Operacao.SAQUE.toString());
			movimentacao.setValor(valorSaque);
			movimentacao.setData(gerarData());

			new ContaDao().insertMovimentacao(movimentacao);

			notifyObservers(conta);

			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque! Seu saldo é de R$ " + conta.getSaldo(),
					"Atenção", JOptionPane.WARNING_MESSAGE);
			return false;
		}

	}

	private java.util.Date gerarData() {
		java.util.Date date = null;
		String data = null;
		try {
			data = new GetHorarioLocal().getHorarioLocal(FormatoData.getDtformattddmmyyyy());
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = formatter.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public boolean transferencia(Conta conta, Conta contaRecebeTransf, BigDecimal valorTransf) {

		BigDecimal contaRecebeSaldoApos = contaRecebeTransf.getSaldo();

		System.out.println(contaRecebeSaldoApos);

		conta = new ContaDao().getConta(conta.getAgencia(), conta.getNumeroConta(), conta.getNome());

		BigDecimal contaSaldoApos = conta.getSaldo();

		if (conta.getSaldo().compareTo(valorTransf) >= 0) {

			conta.setSaldo(contaSaldoApos.subtract(valorTransf));
			contaRecebeTransf.setSaldo(contaRecebeSaldoApos.add(valorTransf));

			new ContaDao().updateSaldo(conta, conta.getSaldo());
			new ContaDao().updateSaldo(contaRecebeTransf, contaRecebeTransf.getSaldo());

			movimentacao.setOperacao(Operacao.TRANSFERENCIA.toString());
			movimentacao.setValor(valorTransf);
			movimentacao.setData(gerarData());

			new ContaDao().insertMovimentacao(movimentacao);

			notifyObservers(conta);
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Saldo insuficiente para transferência! Seu saldo é de R$ " + conta.getSaldo(), "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

	}

	public Conta validaContaTransferencia(Conta contaRecebeTransf) {
		/**
		 * Consulta no banco as informacoes da conta a receber transferencia
		 */
		return contaRecebeTransf = new ContaDao().getConta(contaRecebeTransf.getAgencia(),
				contaRecebeTransf.getNumeroConta(), contaRecebeTransf.getNome());
	}

	@Override
	public boolean pagamento(Conta conta, BigDecimal valorPagam, String codigoDeBarras) {

		conta = new ContaDao().getConta(conta.getAgencia(), conta.getNumeroConta(), conta.getNome());
		BigDecimal saldoApos = conta.getSaldo();

		if (conta.getSaldo().compareTo(valorPagam) >= 0) {

			conta.setSaldo(saldoApos.subtract(valorPagam));

			new ContaDao().updateSaldo(conta, conta.getSaldo());

			movimentacao.setOperacao(Operacao.PAGAMENTO.toString());
			movimentacao.setValor(valorPagam);
			movimentacao.setData(gerarData());

			new ContaDao().insertMovimentacao(movimentacao);

			notifyObservers(conta);

			return true;

		} else {
			JOptionPane.showMessageDialog(null,
					"Saldo insuficiente para pagamento! Seu saldo é de R$ " + conta.getSaldo(), "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

	}

	@Override
	public void finalizarConta(Conta conta) {

		conta = new ContaDao().getConta(conta.getAgencia(), conta.getNumeroConta(), conta.getNome());

		if (conta.getSaldo().compareTo(new BigDecimal(0.00)) > 0) {

			JOptionPane.showMessageDialog(null,
					"Sua " + conta.getTipoConta() + " possui saldo de: " + conta.getSaldo() + ". Impossível inativar");

			notifyObservers(conta);

		} else {
			new ContaDao().inativarConta(conta);
			new UsuarioDao().inativarConta(conta);
		}

	}

}
