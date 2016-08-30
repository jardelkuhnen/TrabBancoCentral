package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;
import javax.swing.JOptionPane;

import br.univel.model.Profissional;

public class ProfissionalDao {

	private static String SQL_INSERT = "INSERT INTO PROFISSIONAL (nome, idade, usuario, senhaAcesso, senhaOperacoes, tipoProfissional) VALUES (?,?,?,?,?,?)";

	public void add(Profissional profisisonal) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = Conexao.getConection();

			stmt = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			writeStatement(profisisonal, stmt);

			int linhasInseridas = stmt.executeUpdate();

			if (linhasInseridas == 0) {
				throw new RuntimeErrorException(null, "Falha ao inserir dados na tabela Profissionais!");
			}

			rs = stmt.getGeneratedKeys();
			rs.next();

			profisisonal.setId(rs.getInt(1));
			JOptionPane.showMessageDialog(null, "Profissional inserido com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, con);
		}

	}

	private void writeStatement(Profissional profisisonal, PreparedStatement stmt) throws SQLException {

		stmt.setString(1, profisisonal.getNome());
		stmt.setInt(2, profisisonal.getIdade());
		stmt.setString(3, profisisonal.getUserName());
		stmt.setString(4, profisisonal.getSenhaAcesso());
		stmt.setString(5, profisisonal.getSenhaOperacoes());
		stmt.setString(6, profisisonal.getTipoProfissional().toString());
	}

	protected void close(ResultSet set, Statement stmt, Connection conn) {
		try {
			if (set != null && !set.isClosed())
				set.close();
			if (stmt != null && !stmt.isClosed())
				stmt.close();
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
