package br.univel.general;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.dao.AgenciaDao;
import br.univel.dao.ContaDao;
import br.univel.dao.UsuarioDao;
import br.univel.enums.Operacao;
import br.univel.interfaces.ContaMethods;
import br.univel.model.Balanco;
import br.univel.model.Conta;
import br.univel.model.FormatoData;
import br.univel.model.Movimentacao;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class MovimentacaoFacade implements ContaMethods, Observable {

	ContaDao contaDao = new ContaDao();

	List<InvalidationListener> observers = new ArrayList<>();

	Movimentacao movimentacao = new Movimentacao();
	Balanco balanco = new Balanco();

	public void addObservers(InvalidationListener listener) {
		observers.add(listener);
	}

	@Override
	public void deposito(Conta conta, BigDecimal valorDeposito) {

		BigDecimal vlrAtualizar = conta.getSaldo().add(valorDeposito);

		conta.setSaldo(vlrAtualizar);
		new ContaDao().updateSaldo(conta, vlrAtualizar);

		writeMovimentacao(valorDeposito, Operacao.DEPOSITO, conta);
		writeBalanco(valorDeposito, conta, Operacao.DEPOSITO);
		new ContaDao().insertMovimentacao(movimentacao);
		new AgenciaDao().insertBalanco(balanco);

	}

	@Override
	public boolean saque(Conta conta, BigDecimal valorSaque, String senhaInformada) {

		conta = new ContaDao().getConta(conta.getAgencia(), conta.getNumeroConta(), conta.getNome());

		BigDecimal saldoApos = conta.getSaldo();

		if (conta.getSaldo().compareTo(valorSaque) >= 0) {

			saldoApos = saldoApos.subtract(valorSaque);

			conta.setSaldo(new BigDecimal(saldoApos.toString()));

			new ContaDao().updateSaldo(conta, conta.getSaldo());

			writeMovimentacao(valorSaque, Operacao.SAQUE, conta);
			writeBalanco(valorSaque, conta, Operacao.SAQUE);

			new ContaDao().insertMovimentacao(movimentacao);
			new AgenciaDao().insertBalanco(balanco);

			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque! Seu saldo é de R$ " + conta.getSaldo(),
					"Atenção", JOptionPane.WARNING_MESSAGE);
			return false;
		}

	}

	/**
	 * Insere no objeto as informações da operacao realizada
	 * 
	 * @param valor
	 * @param operacao
	 */
	private void writeMovimentacao(BigDecimal valor, Operacao operacao, Conta conta) {
		
		movimentacao.setValor(valor);
		movimentacao.setData(gerarData());
		movimentacao.setAgencia(conta.getAgencia());
		movimentacao.setConta(conta.getNumeroConta());

		switch (operacao) {
		case SAQUE:
			movimentacao.setOperacao(Operacao.SAQUE.toString());
			break;
		case PAGAMENTO:
			movimentacao.setOperacao(Operacao.PAGAMENTO.toString());
			break;
		case DEPOSITO:
			movimentacao.setOperacao(Operacao.DEPOSITO.toString());
			break;
		case TRANSFERENCIA:
			movimentacao.setOperacao(Operacao.TRANSFERENCIA.toString());
			break;
		default:
			break;
		}

	}

	private java.util.Date gerarData() {
		java.util.Date date = null;
		String data = null;
		try {
			data = new GetHorarioLocal().getHorarioLocal(FormatoData.getDtformattddmmyyyyhhmm());
			DateFormat formatter = new SimpleDateFormat(FormatoData.getDtformattddmmyyyyhhmm());
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

			writeMovimentacao(valorTransf, Operacao.TRANSFERENCIA, conta);
			writeBalanco(valorTransf, conta, Operacao.TRANSFERENCIA);

			new ContaDao().insertMovimentacao(movimentacao);

			new AgenciaDao().insertBalanco(balanco);

			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Saldo insuficiente para transferência! Seu saldo é de R$ " + conta.getSaldo(), "Atenção",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

	}

	private void writeBalanco(BigDecimal valor, Conta conta, Operacao operacao) {

		balanco.setAgenca(conta.getAgencia());
		balanco.setConta(conta.getNumeroConta());
		balanco.setData(gerarData());
		balanco.setValor(valor);

		switch (operacao) {
		case SAQUE:
			balanco.setOperacao(Operacao.SAQUE.toString());
			break;
		case DEPOSITO:
			balanco.setOperacao(Operacao.DEPOSITO.toString());
			break;
		case PAGAMENTO:
			balanco.setOperacao(Operacao.PAGAMENTO.toString());
			break;
		case TRANSFERENCIA:
			balanco.setOperacao(Operacao.TRANSFERENCIA.toString());
			break;
		default:
			break;
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

			writeMovimentacao(valorPagam, Operacao.PAGAMENTO, conta);
			writeBalanco(valorPagam, conta, Operacao.PAGAMENTO);

			new ContaDao().insertMovimentacao(movimentacao);

			new AgenciaDao().insertBalanco(balanco);

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

		} else {
			new ContaDao().inativarConta(conta);
			new UsuarioDao().inativarConta(conta);
		}

	}

	@Override
	public void addListener(InvalidationListener listener) {
		observers.add(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener) {

	}

}
