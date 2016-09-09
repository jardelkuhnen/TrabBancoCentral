package br.univel.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.dao.AgenciaDao;
import br.univel.dao.ContaDao;
import br.univel.dao.UsuarioDao;
import br.univel.enun.TipoUsuario;
import br.univel.general.MovimentacaoFacade;
import br.univel.general.Sha256Hash;
import br.univel.interfacee.Command;
import br.univel.interfacee.ContaMethods;
import br.univel.model.Conta;
import br.univel.model.Usuario;

public class ContaController implements ContaMethods {

	public void add(Conta conta) {

		Integer agExiste = new AgenciaDao().getNumero(conta.getAgencia());

		if (agExiste > 0) {

			Command commandUser = new Sha256Hash(conta.getUsuarioAcesso());
			String userAcessoHash = commandUser.execute();

			Command commandSenha = new Sha256Hash(conta.getSenhaAcesso());
			String senhaAcessoHash = commandSenha.execute();

			Usuario usuario = new Usuario(userAcessoHash, senhaAcessoHash, TipoUsuario.CLIENTE);

			conta.setUsuarioAcesso(userAcessoHash);
			conta.setSenhaAcesso(senhaAcessoHash);

			try {

				new ContaDao().add(conta);
				new UsuarioDao().add(usuario);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			String mensagem = "Agência " + conta.getAgencia() + " inexistente!!!";
			JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}

	public List<Conta> buscarContas() throws SQLException {

		return new ContaDao().buscarContas();
	}

	public Conta get(String usuario, String senha) {

		Command commandUser = new Sha256Hash(usuario);
		String userAcessoHash = commandUser.execute();

		Command commandSenha = new Sha256Hash(senha);
		String senhaAcessoHash = commandSenha.execute();

		return new ContaDao().get(userAcessoHash, senhaAcessoHash);
	}

	public Conta getContaDeposito(String agencia, String numero, String titular) {

		return new ContaDao().getContaDeposito(agencia, numero, titular);
	}

	@Override
	public void deposito(Conta conta, BigDecimal valorDeposito) {

		conta = new ContaDao().getContaDeposito(conta.getAgencia(), conta.getNumeroConta(), conta.getNome());

		if (conta.getId() == null) {
			JOptionPane.showMessageDialog(null, "Conta não localizada. Verifique!", "Atenção",
					JOptionPane.WARNING_MESSAGE);
		} else {

			new MovimentacaoFacade().deposito(conta, valorDeposito);
		}
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
