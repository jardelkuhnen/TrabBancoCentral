package br.univel.dao;

import java.sql.Connection;

import br.univel.model.Bancario;

public class BancarioDao {

	
	Connection con;
	
	
	public void addBancario(Bancario bancario){
		
		
		con = Conexao.getConection();
		
		
		
		
	}

	
	
	
	
	
}
