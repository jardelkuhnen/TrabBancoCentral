package br.univel.controller;

import br.univel.dao.UsuarioDao;

public class UsuarioController {

	public boolean acessoLogin(String usuario, String senha) {

		UsuarioDao userDao = new UsuarioDao();

		boolean login = userDao.acessoLogin(usuario, senha);
		
		return login;

	}

}
