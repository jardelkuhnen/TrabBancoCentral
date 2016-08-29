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
import br.univel.model.Conta;

public class ContaDao {

	private static String SQL_INSERT = "INSERT INTO CONTA (NOME, IDADE, CPF, AGENCIA, TIPOCONTA, SENHAACESSO, SENHAOPERACOES, NUMEROCONTA) VALUES (?,?,?,?,?,?,?,?)";
	private static String SQL_SELECT_ALL = "SELECT * FROM CONTA";

	public void add(Conta conta) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs;
		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			writeStatemento(conta, stmt);

			int linhasInseridas = stmt.executeUpdate();
			if (linhasInseridas == 0)
				throw new RuntimeException("Falha ao inserir dados");

			rs = stmt.getGeneratedKeys();
			rs.next();
			conta.setId(rs.getInt(1));
			JOptionPane.showMessageDialog(null,
					conta.getTipoConta() + " " + conta.getNumeroConta() + " inserida com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, stmt, con);
		}
	}

	private void writeStatemento(Conta conta, PreparedStatement stmt) throws SQLException {

		stmt.setString(1, conta.getNome());
		stmt.setInt(2, conta.getIdade());
		stmt.setString(3, conta.getCpf());
		stmt.setString(4, conta.getAgencia());
		stmt.setString(5, conta.getTipoConta().toString());
		stmt.setString(6, conta.getSenhaAcesso());
		stmt.setString(7, conta.getSenhaOperacoes());
		stmt.setString(8, conta.getNumeroConta());
	}

	public List<Conta> buscarContas() throws SQLException {
		List<Conta> contas = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();

			while (rs.next()) {
				contas.add((Conta) readResultSet(rs));
			}

			return contas;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, con);
		}
		return contas;

	}

	private Object readResultSet(ResultSet rs) throws SQLException {

		Integer id = rs.getInt("id");
		String nome = rs.getString("nome");
		Integer idade = rs.getInt("idade");
		String cpf = rs.getString("cpf");
		String agencia = rs.getString("agencia");
		String tipoConta = rs.getString("tipoConta");

		return new Conta(id, nome, idade, cpf, agencia, tipoConta);
	}

	private void close(ResultSet rs, PreparedStatement stmt, Connection con) throws SQLException {
		if (rs != null && !rs.isClosed())
			rs.close();
		if (stmt != null && !stmt.isClosed())
			stmt.close();
		if (con != null && !con.isClosed())
			con.close();

	}

}
