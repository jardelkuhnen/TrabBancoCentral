package br.univel.controller;

import java.sql.SQLException;
import java.util.List;

import br.univel.dao.AgenciaDao;
import br.univel.model.Agencia;
import br.univel.model.Balanco;

public class AgenciaController {

	public void add(Agencia agencia) {

		try {
			new AgenciaDao().addAgencia(agencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Agencia get(Integer idAgencia) throws SQLException {

		return new AgenciaDao().get(idAgencia);
	}

	public void edit(Agencia agencia) {

		new AgenciaDao().edit(agencia);

	}

	public List<Agencia> buscarAgencias() {

		return new AgenciaDao().buscarAgencias();
	}

	public List<Balanco> getBalanco(String agencia) {

		return new AgenciaDao().getBalanco(agencia);
	}

}
