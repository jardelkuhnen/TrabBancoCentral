package br.univel.controller;

import br.univel.dao.UsuarioDao;
import br.univel.enun.TipoUsuario;
import br.univel.interfacee.Command;
import br.univel.model.MD5Hash;
import br.univel.model.Usuario;

public class UsuarioController extends Usuario {

	public TipoUsuario acessoLogin(String usuario, String senha) {

		Command usuarioHash = new MD5Hash(usuario);
		Command senhaHash = new MD5Hash(senha);

		UsuarioDao userDao = new UsuarioDao();
		TipoUsuario login = userDao.acessoLogin(usuarioHash.toString(),
				senhaHash.toString());

		return login;

	}

	public void addUser(Usuario usuario) {

		UsuarioController userControll = new UsuarioController();

		Command usuarioHash = new MD5Hash(usuario.getUsuario());
		Command senhaHash = new MD5Hash(usuario.getSenha());

		userControll.setId(usuario.getId());
		userControll.setUsuario(usuarioHash.toString());
		userControll.setSenha(senhaHash.toString());
		userControll.setTipoUsuario(usuario.getTipoUsuario());
		
		UsuarioDao userDao = new UsuarioDao();
		
		userDao.addUser(userControll);
		

	}
}
