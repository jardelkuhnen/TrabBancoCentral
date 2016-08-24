package br.univel.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.model.Agencia;

public class AgenciaDao {

	private static String SQL_SELECT_ALL = "SELECT * FROM AGENCIA";

	public void addAgencia(Agencia agencia) {

		// String sql = "INSERT INTO AGENCIA ID, NOME, NUMERO, CIDADE"

	}

	public List<Agencia> buscarAgencias() throws SQLException {

		List<Agencia> agencias = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();

			while (rs.next()) {
				agencias.add(readResultSet(rs));
			}
			return agencias;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, con);
		}

		return null;
	}

	private void close(ResultSet rs, PreparedStatement stmt, Connection con) throws SQLException {
		if (rs != null && !rs.isClosed())
			rs.close();
		if (stmt != null && !stmt.isClosed())
			stmt.close();
		if (con != null && !con.isClosed())
			con.close();

	}

	// Metodo faz leitura de todos os campos da agencia no banco e adicionar no
	// resultSet
	private Agencia readResultSet(ResultSet rs) throws SQLException {
		Integer id = rs.getInt("id");
		String nome = rs.getString("nome");
		String numero = rs.getString("numero");
		String cidade = rs.getString("cidade");

		return new Agencia(id, nome, numero, cidade);
	}
}
