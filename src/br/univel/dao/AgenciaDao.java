package br.univel.dao;

import java.sql.Connection;

import br.univel.model.Agencia;

public class AgenciaDao {

	Connection con;

	
	public void addAgencia(Agencia agencia){
		
		con = Conexao.getConection();
		
//		String sql = "INSERT INTO AGENCIA ID, NOME, NUMERO, CIDADE"
		
	}
}
