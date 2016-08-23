package br.univel.controller;

import java.util.List;

import br.univel.dao.UsuarioDao;
import br.univel.enun.TipoUsuario;
import br.univel.interfacee.Command;
import br.univel.model.MD5Hash;
import br.univel.model.Sha256Hash;
import br.univel.model.Usuario;

public class UsuarioController {

	public boolean acessoLogin(String usuario, String senha, TipoUsuario tipoUsuario) {
		UsuarioDao userDao = new UsuarioDao();
		boolean login = false;
		if (tipoUsuario == TipoUsuario.CLIENTE) {

			Command usuarioHash = new Sha256Hash(usuario);
			Command senhaHash = new Sha256Hash(senha);

			login = userDao.acessoLogin(usuarioHash.toString(), senhaHash.toString());

		} else if (tipoUsuario == TipoUsuario.BANCARIO) {

			Command bancarioHash = new MD5Hash(usuario);
			Command senhaHash = new MD5Hash(senha);

			login = userDao.acessoLogin(bancarioHash.toString(), senhaHash.toString());
		}

		return login;

	}

	public void add(Usuario usuario) {

		Command usuarioHash = new MD5Hash(usuario.getUsuario());
		Command senhaHash = new MD5Hash(usuario.getSenha());

		usuario.setId(usuario.getId());
		usuario.setUsuario(usuarioHash.toString());
		usuario.setSenha(senhaHash.toString());
		usuario.setTipoUsuario(usuario.getTipoUsuario());

		UsuarioDao userDao = new UsuarioDao();

		userDao.addUser(usuario);

	}

	public List<Usuario> get() {

		return null;

	}
}
