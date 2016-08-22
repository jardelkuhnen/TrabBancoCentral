package br.univel.controller;

import java.util.List;

import br.univel.dao.UsuarioDao;
import br.univel.enun.TipoUsuario;
import br.univel.interfacee.Command;
import br.univel.model.MD5Hash;
import br.univel.model.Usuario;

public class UsuarioController {

	public TipoUsuario acessoLogin(String usuario, String senha) {

		Command usuarioHash = new MD5Hash(usuario);
		Command senhaHash = new MD5Hash(senha);

		UsuarioDao userDao = new UsuarioDao();
		TipoUsuario login = userDao.acessoLogin(usuarioHash.toString(),
				senhaHash.toString());

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

	
	public List<Usuario> get(){
		
		
		
		return null;
		
	}
}
