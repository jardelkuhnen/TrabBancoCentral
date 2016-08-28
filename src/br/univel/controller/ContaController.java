package br.univel.controller;

import javax.swing.JOptionPane;

import br.univel.dao.AgenciaDao;
import br.univel.dao.ContaDao;
import br.univel.interfacee.Command;
import br.univel.model.Conta;
import br.univel.model.MD5Hash;
import br.univel.view.CadConta;

public class ContaController {

	public void add(Conta conta) {

		Integer agExiste = new AgenciaDao().getNumero(conta.getAgencia());

		if (agExiste > 0) {

			Command commandUser = new MD5Hash(conta.getUsuarioAcesso());
			String userAcessoHash = commandUser.execute();

			Command commandSenha = new MD5Hash(conta.getSenhaAcesso());
			String senhaAcessoHash = commandSenha.execute();

			conta.setUsuarioAcesso(userAcessoHash);
			conta.setSenhaAcesso(senhaAcessoHash);

			new ContaDao().add(conta);

		} else {
			String mensagem = "Agência " + conta.getAgencia() + " inexistente!!!";
			JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}

}
