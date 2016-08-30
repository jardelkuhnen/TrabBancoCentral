package br.univel.controller;

import br.univel.dao.ProfissionalDao;
import br.univel.dao.UsuarioDao;
import br.univel.general.MD5Hash;
import br.univel.general.Sha256Hash;
import br.univel.interfacee.Command;
import br.univel.model.Profissional;
import br.univel.model.Usuario;

public class ProfissionalController {

	public void add(Profissional profisisonal) {

		if (profisisonal.getTipoProfissional().equals("CLIENTE")) {

			Command commandUser = new Sha256Hash(profisisonal.getUserName());
			String usuarioHash = commandUser.execute();

			Command commandSenha = new Sha256Hash(profisisonal.getSenhaAcesso());
			String senhaHash = commandSenha.execute();

			profisisonal.setSenhaAcesso(senhaHash);
			profisisonal.setUserName(usuarioHash);

			Usuario usuario = new Usuario(usuarioHash, senhaHash, profisisonal.getTipoProfissional());


			new ProfissionalDao().add(profisisonal);
			
			new UsuarioDao().add(usuario);

		} else if (profisisonal.getTipoProfissional().equals("BANCARIO")) {

			Command commandUser = new MD5Hash(profisisonal.getUserName());
			String usuarioHash = commandUser.execute();

			Command commandSenha = new MD5Hash(profisisonal.getSenhaAcesso());
			String senhaHash = commandSenha.execute();

			profisisonal.setSenhaAcesso(senhaHash);
			profisisonal.setUserName(usuarioHash);

			new ProfissionalDao().add(profisisonal);

		}

	}

}
