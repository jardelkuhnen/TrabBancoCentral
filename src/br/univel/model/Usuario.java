package br.univel.model;

import br.univel.enums.TipoUsuario;

public class Usuario {

	private int id;
	private String usuario;
	private String senha;
	private TipoUsuario tipoUsuario;
	private String situacaoBancaria;

	public Usuario(String usuario, String senha, TipoUsuario tipoUsuario, String situacaoBancaria) {
		this.usuario = usuario;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.situacaoBancaria = situacaoBancaria;
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

	public String getSituacaoBancaria() {
		return situacaoBancaria;
	}

	public void setSituacaoBancaria(String situacaoBancaria) {
		this.situacaoBancaria = situacaoBancaria;
	}

}
