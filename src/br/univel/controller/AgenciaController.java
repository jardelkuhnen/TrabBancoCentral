package br.univel.controller;

import java.sql.SQLException;

import br.univel.dao.AgenciaDao;
import br.univel.model.Agencia;

public class AgenciaController {

	public void add(Agencia agencia) {

		
		agencia.setId(agencia.getId());
		agencia.setNome(agencia.getNome());
		agencia.setCidade(agencia.getCidade());
		
		new AgenciaDao().addAgencia(agencia);
		
	}

	public Agencia get(Integer idAgencia) throws SQLException {

		
		return new AgenciaDao().get(idAgencia);
	}


}
