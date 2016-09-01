package br.univel.controller;

import java.sql.SQLException;
import java.util.List;

import br.univel.dao.ProfissionalDao;
import br.univel.dao.UsuarioDao;
import br.univel.enun.TipoUsuario;
import br.univel.general.MD5Hash;
import br.univel.general.Sha256Hash;
import br.univel.interfacee.Command;
import br.univel.model.Profissional;
import br.univel.model.Usuario;

public class ProfissionalController {

	public void add(Profissional profisisonal) {

		if (profisisonal.getTipoProfissional().equals(TipoUsuario.CLIENTE)) {

			Command commandUser = new Sha256Hash(profisisonal.getUserName());
			String usuarioHash = commandUser.execute();

			Command commandSenha = new Sha256Hash(profisisonal.getSenhaAcesso());
			String senhaHash = commandSenha.execute();

			profisisonal.setSenhaAcesso(senhaHash);
			profisisonal.setUserName(usuarioHash);

			Usuario usuario = new Usuario(usuarioHash, senhaHash, profisisonal.getTipoProfissional());

			new ProfissionalDao().add(profisisonal);

			new UsuarioDao().add(usuario);

		} else if (profisisonal.getTipoProfissional().equals(TipoUsuario.BANCARIO)) {

			Command commandUser = new MD5Hash(profisisonal.getUserName());
			String usuarioHash = commandUser.execute();

			Command commandSenha = new MD5Hash(profisisonal.getSenhaAcesso());
			String senhaHash = commandSenha.execute();

			Usuario usuario = new Usuario(usuarioHash, senhaHash, profisisonal.getTipoProfissional());

			profisisonal.setSenhaAcesso(senhaHash);
			profisisonal.setUserName(usuarioHash);

			new ProfissionalDao().add(profisisonal);

			new UsuarioDao().add(usuario);

		}

	}

	public List<Profissional> buscarProfissionais() {

		return new ProfissionalDao().buscarProfissionais();
	}

	public Profissional get(Integer idProfissional) throws SQLException {

		return new ProfissionalDao().get(idProfissional);
	}

	public void edit(Profissional profissional) {

		if (profissional.getTipoProfissional().equals(TipoUsuario.CLIENTE)) {

			Command commandUser = new Sha256Hash(profissional.getUserName());
			String usuarioHash = commandUser.execute();

			Command commandSenha = new Sha256Hash(profissional.getSenhaAcesso());
			String senhaHash = commandSenha.execute();

			profissional.setSenhaAcesso(senhaHash);
			profissional.setUserName(usuarioHash);
			
			new UsuarioDao().edit(new Usuario(usuarioHash, senhaHash, TipoUsuario.CLIENTE), profissional.getId());
			new ProfissionalDao().edit(profissional);

		} else if (profissional.getTipoProfissional().equals(TipoUsuario.BANCARIO)) {

			Command commandUser = new MD5Hash(profissional.getUserName());
			String usuarioHash = commandUser.execute();

			Command commandSenha = new MD5Hash(profissional.getSenhaAcesso());
			String senhaHash = commandSenha.execute();

			new UsuarioDao().edit(new Usuario(usuarioHash, senhaHash, TipoUsuario.BANCARIO), profissional.getId());

			new ProfissionalDao().edit(profissional);
		}

	}

}
