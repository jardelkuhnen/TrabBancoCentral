package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.model.Agencia;

public class AgenciaDao {

	private static final String SQL_GET_AGENCI_ID = "SELECT * FROM AGENCIA WHERE ID = ?";
	private static final String SQL_UPDATE = "UPDATE AGENCIA SET NOME = ?, NUMERO = ?, CIDADE = ? WHERE ID = ?";
	private static String SQL_SELECT_ALL = "SELECT * FROM AGENCIA";
	private static String SQL_INSERT = "INSERT INTO AGENCIA (NOME, NUMERO, CIDADE) VALUES (?,?,?)";

	public void addAgencia(Agencia agencia) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs;

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			writeStatement(agencia, stmt);

			int linhasInseridas = stmt.executeUpdate();

			if (linhasInseridas == 0)
				throw new RuntimeException("Falha ao inserir dados na tabela Agencia");

			rs = stmt.getGeneratedKeys();
			rs.next();
			agencia.setId(rs.getInt(1));
			JOptionPane.showMessageDialog(null, "Agência inserida com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void writeStatement(Agencia agencia, PreparedStatement stmt) throws SQLException {

		stmt.setString(1, agencia.getNome());
		stmt.setString(2, agencia.getNumero());
		stmt.setString(3, agencia.getCidade());

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

	public Agencia get(Integer idAgencia) throws SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			con = Conexao.getConection();

			stmt = con.prepareStatement(SQL_GET_AGENCI_ID);
			stmt.setInt(1, idAgencia);

			rs = stmt.executeQuery();
			rs.next();

			return readResultSet(rs);
		} finally {
			close(rs, stmt, con);
		}

	}

	public void edit(Agencia agencia) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs;

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_UPDATE);
			writeStatement(agencia, stmt);
			
			stmt.setInt(4, agencia.getId());

			int linhasInseridas = stmt.executeUpdate();

			if (linhasInseridas == 0)
				throw new RuntimeException("Falha ao inserir dados na tabela Agencia");

			JOptionPane.showMessageDialog(null, "Agência inserida com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
