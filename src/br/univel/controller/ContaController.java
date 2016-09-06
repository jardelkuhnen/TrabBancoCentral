package br.univel.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.dao.AgenciaDao;
import br.univel.dao.ContaDao;
import br.univel.dao.UsuarioDao;
import br.univel.enun.TipoUsuario;
import br.univel.general.MD5Hash;
import br.univel.general.Sha256Hash;
import br.univel.interfacee.Command;
import br.univel.model.Conta;
import br.univel.model.Usuario;
import br.univel.view.CadConta;

public class ContaController {

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
			String mensagem = "Ag�ncia " + conta.getAgencia() + " inexistente!!!";
			JOptionPane.showMessageDialog(null, mensagem, "Aten��o", JOptionPane.ERROR_MESSAGE);
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
	
	
	public void deposito(){
		
		
		
	}

}
