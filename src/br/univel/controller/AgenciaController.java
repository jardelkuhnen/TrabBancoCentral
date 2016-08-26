package br.univel.controller;

import java.sql.SQLException;

import br.univel.dao.AgenciaDao;
import br.univel.model.Agencia;

public class AgenciaController {

	public void add(Agencia agencia) {

		new AgenciaDao().addAgencia(agencia);
		
	}

	public Agencia get(Integer idAgencia) throws SQLException {

		
		return new AgenciaDao().get(idAgencia);
	}

	public void edit(Agencia agencia) {

		new AgenciaDao().edit(agencia);
		
	}


}
