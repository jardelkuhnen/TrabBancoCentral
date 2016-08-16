package br.univel.controller;

import br.univel.dao.UsuarioDao;
import br.univel.enun.TipoUsuario;

public class UsuarioController {

	public TipoUsuario acessoLogin(String usuario, String senha) {

		UsuarioDao userDao = new UsuarioDao();

		TipoUsuario login = userDao.acessoLogin(usuario, senha);

		return login;

	}

}
