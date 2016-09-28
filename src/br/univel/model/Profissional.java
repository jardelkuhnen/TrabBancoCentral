package br.univel.model;

import br.univel.enums.TipoUsuario;

public class Profissional {

	private Integer id;
	private String nome;
	private Integer idade;
	private String usuario;
	private String senhaAcesso;
	private String senhaOperacoes;
	private TipoUsuario tipoProfissional;

	public Profissional(Integer id, String nome, String usuario, Integer idade, String senhaAcesso,
			String senhaOperacoes, TipoUsuario tipoProfissional) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.idade = idade;
		this.senhaAcesso = senhaAcesso;
		this.senhaOperacoes = senhaOperacoes;
		this.tipoProfissional = tipoProfissional;
	}

	public Profissional() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getUserName() {
		return usuario;
	}

	public void setUserName(String userName) {
		this.usuario = userName;
	}

	public String getSenhaAcesso() {
		return senhaAcesso;
	}

	public void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}

	public String getSenhaOperacoes() {
		return senhaOperacoes;
	}

	public void setSenhaOperacoes(String senhaOperacoes) {
		this.senhaOperacoes = senhaOperacoes;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public TipoUsuario getTipoProfissional() {
		return tipoProfissional;
	}

	public void setTipoProfissional(TipoUsuario tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}

}
