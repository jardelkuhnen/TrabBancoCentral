package br.univel.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.interfacee.ContaMethods;
import br.univel.model.Conta;

public class ContaDao {

	private static final String SQL_GET_CONTA = "SELECT * FROM CONTA WHERE USUARIOACESSO = ? AND SENHAACESSO = ?";
	private static final String SQL_GET_CONTADEPOSITO = "SELECT * FROM CONTA WHERE AGENCIA = ? AND NUMEROCONTA = ? AND NOME = ?";
	private static final String SQL_INSERT = "INSERT INTO CONTA (NOME, IDADE, CPF, AGENCIA, TIPOCONTA, USUARIOACESSO, SENHAACESSO, SENHAOPERACOES, NUMEROCONTA, SALDO) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT_ALL = "SELECT * FROM CONTA";
	private static final String SQL_UPDATE_SALDO_CONTA = "UPDATE CONTA SET SALDO = ? WHERE NUMEROCONTA = ? AND NOME = ?";

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
		stmt.setString(6, conta.getUsuarioAcesso());
		stmt.setString(7, conta.getSenhaAcesso());
		stmt.setString(8, conta.getSenhaOperacoes());
		stmt.setString(9, conta.getNumeroConta());
		stmt.setBigDecimal(10, conta.getSaldo());
	}

	public Conta get(String userAcessoHash, String senhaAcessoHash) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Conta conta = new Conta();

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_GET_CONTA);

			stmt.setString(1, userAcessoHash);
			stmt.setString(2, senhaAcessoHash);

			rs = stmt.executeQuery();

			while (rs.next()) {
				conta = (Conta) readResultSet(rs);
			}

			return conta;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
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
		String senhaOperacoes = rs.getString("senhaOperacoes");
		String usuarioAcesso = rs.getString("usuarioAcesso");
		String senhaAcesso = rs.getString("senhaAcesso");
		String numeroConta = rs.getString("numeroConta");
		BigDecimal saldo = rs.getBigDecimal("saldo");

		return new Conta(id, nome, idade, cpf, agencia, tipoConta, usuarioAcesso, senhaAcesso, senhaOperacoes,
				numeroConta, saldo);
	}

	private void close(ResultSet rs, PreparedStatement stmt, Connection con) throws SQLException {
		if (rs != null && !rs.isClosed())
			rs.close();
		if (stmt != null && !stmt.isClosed())
			stmt.close();
		if (con != null && !con.isClosed())
			con.close();

	}

	public Conta getConta(String agencia, String numero, String titular) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Conta conta = null;

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_GET_CONTADEPOSITO);

			stmt.setString(1, agencia);
			stmt.setString(2, numero);
			stmt.setString(3, titular);

			rs = stmt.executeQuery();

			while (rs.next()) {
				conta = (Conta) readResultSet(rs);
			}

			return conta;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
	}

	public void updateSaldo(Conta conta, BigDecimal valorDeposito) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_UPDATE_SALDO_CONTA);

			stmt.setBigDecimal(1, valorDeposito);
			stmt.setString(2, conta.getNumeroConta());
			stmt.setString(3, conta.getNome());

			int linhasAtualizadas = stmt.executeUpdate();

			if (linhasAtualizadas == 0)
				throw new RuntimeException("Falha ao realizar operação!!!");

			JOptionPane.showMessageDialog(null, "Saldo atualizado com sucesso!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
