package br.univel.model;

import br.univel.enun.TipoUsuario;

public class Usuario {

	private int id;
	private String usuario;
	private String senha;
	private TipoUsuario tipoUsuario;

	public Usuario(String usuario, String senha, TipoUsuario tipoUsuario) {
		this.usuario = usuario;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
