package br.univel.controller;

import java.util.List;

import br.univel.dao.UsuarioDao;
import br.univel.enun.TipoUsuario;
import br.univel.general.MD5Hash;
import br.univel.general.Sha256Hash;
import br.univel.interfacee.Command;
import br.univel.model.Usuario;

public class UsuarioController {

	public boolean acessoLogin(String usuario, String senha, TipoUsuario tipoUsuario) {

		UsuarioDao userDao = new UsuarioDao();
		boolean login = false;

		if (tipoUsuario == TipoUsuario.CLIENTE) {

			Command commandUser = new Sha256Hash(usuario);
			String usuarioHash = commandUser.execute();

			Command commandPass = new Sha256Hash(senha);
			String senhaHash = commandPass.execute();

			login = userDao.acessoLogin(usuarioHash, senhaHash);

		} else if (tipoUsuario == TipoUsuario.BANCARIO) {

			Command commandUser = new MD5Hash(usuario);
			String usuarioHash = commandUser.execute();
			Command commandPass = new MD5Hash(senha);
			String senhaHash = commandPass.execute();

			login = userDao.acessoLogin(usuarioHash, senhaHash);
		}

		return login;

	}

	public void add(Usuario usuario) {

		Command commandUser = new MD5Hash(usuario.getUsuario());
		String usuarioHash = commandUser.execute();

		Command commandPass = new MD5Hash(usuario.getSenha());
		String senhaHash = commandPass.execute();

		usuario.setId(usuario.getId());
		usuario.setUsuario(usuarioHash.toString());
		usuario.setSenha(senhaHash.toString());
		usuario.setTipoUsuario(usuario.getTipoUsuario());

		new UsuarioDao().add(usuario);

	}

}
