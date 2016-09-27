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

	private static String SQL_SELECT_AGENCIA = "SELECT COUNT(*) FROM AGENCIA WHERE NUMERO = ?";
	private static String SQL_GET_AGENCI_ID = "SELECT * FROM AGENCIA WHERE ID = ?";
	private static String SQL_UPDATE = "UPDATE AGENCIA SET NOME = ?, NUMERO = ?, CIDADE = ? WHERE ID = ?";
	private static String SQL_SELECT_ALL = "SELECT * FROM AGENCIA ORDER BY ID";
	private static String SQL_INSERT = "INSERT INTO AGENCIA (NOME, NUMERO, CIDADE) VALUES (?,?,?)";

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public void addAgencia(Agencia agencia) throws SQLException {

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
		} finally {
			Conexao.close(rs, stmt, con);
		}

	}

	private void writeStatement(Agencia agencia, PreparedStatement stmt) throws SQLException {

		stmt.setString(1, agencia.getNome());
		stmt.setString(2, agencia.getNumero());
		stmt.setString(3, agencia.getCidade());

	}

	public List<Agencia> buscarAgencias() {
		List<Agencia> agencias = new ArrayList<>();

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
			Conexao.close(rs, stmt, con);
		}

		return agencias;
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

		try {

			con = Conexao.getConection();

			stmt = con.prepareStatement(SQL_GET_AGENCI_ID);
			stmt.setInt(1, idAgencia);

			rs = stmt.executeQuery();
			rs.next();

			return readResultSet(rs);
		} finally {
			Conexao.close(rs, stmt, con);
		}

	}

	public void edit(Agencia agencia) {

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_UPDATE);
			writeStatement(agencia, stmt);

			stmt.setInt(4, agencia.getId());

			int linhasInseridas = stmt.executeUpdate();

			if (linhasInseridas == 0)
				throw new RuntimeException("Falha ao inserir dados na tabela Agencia");

			JOptionPane.showMessageDialog(null, "Agência atualizada com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.close(null, stmt, con);
		}

	}

	public Integer getNumero(String nAgencia) {

		int agEncontradas = 0;
		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_SELECT_AGENCIA);

			stmt.setString(1, nAgencia);

			rs = stmt.executeQuery();

			if (rs.next()) {
				agEncontradas = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.close(rs, stmt, con);
		}
		return agEncontradas;
	}

}
