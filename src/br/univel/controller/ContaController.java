package br.univel.controller;

import javax.swing.JOptionPane;

import br.univel.dao.AgenciaDao;
import br.univel.dao.ContaDao;
import br.univel.dao.UsuarioDao;
import br.univel.enun.TipoUsuario;
import br.univel.interfacee.Command;
import br.univel.model.Conta;
import br.univel.model.MD5Hash;
import br.univel.model.Sha256Hash;
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


			new ContaDao().add(conta);

			new UsuarioDao().add(usuario);

		} else {
			String mensagem = "Agência " + conta.getAgencia() + " inexistente!!!";
			JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}

}
