package br.univel.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.model.Conta;
import br.univel.model.Movimentacao;

public class ContaDao {

	private static String SQL_GET_CONTA = "SELECT * FROM CONTA WHERE USUARIOACESSO = ? AND SENHAACESSO = ? AND SITUACAO = 'ATIVO'";
	private static String SQL_GET_CONTA_DEPOSITO = "SELECT * FROM CONTA WHERE AGENCIA = ? AND NUMEROCONTA = ? AND NOME = ? AND SITUACAO = 'ATIVO'";
	private static String SQL_INSERT = "INSERT INTO CONTA (NOME, IDADE, CPF, AGENCIA, TIPOCONTA, USUARIOACESSO, SENHAACESSO, SENHAOPERACOES, NUMEROCONTA, SALDO, SITUACAO) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static String SQL_SELECT_ALL = "SELECT * FROM CONTA WHERE SITUACAO = 'ATIVO'";
	private static String SQL_UPDATE_SALDO_CONTA = "UPDATE CONTA SET SALDO = ? WHERE NUMEROCONTA = ? AND NOME = ?";
	private static String SQL_INATIVAR = "UPDATE CONTA SET SITUACAO = 'INATIVO' WHERE ID = ?";
	private static String SQL_INSERT_MOVIMENTAO = "INSERT INTO MOVIMENTACAO (OPERACAO, DATA, VALOR, AGENCIA, CONTA) VALUES (?,?,?,?,?)";
	private static String SQL_SELECT_ALL_MOVIMENTACAO = "SELECT * FROM MOVIMENTACAO WHERE CONTA = ? ORDER BY ID";

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public void add(Conta conta) {
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
			Conexao.close(rs, stmt, con);
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
		stmt.setString(11, conta.getSituacaoBancaria());
	}

	public Conta get(String userAcessoHash, String senhaAcessoHash) {

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

	public List<Conta> buscarContas() {
		List<Conta> contas = new ArrayList<>();

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
			Conexao.close(rs, stmt, con);
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
		String situacaoBancaria = rs.getString("situacao");

		return new Conta(id, nome, idade, cpf, agencia, tipoConta, usuarioAcesso, senhaAcesso, senhaOperacoes,
				numeroConta, saldo, situacaoBancaria);
	}

	public Conta getConta(String agencia, String numero, String titular) {

		Conta conta = null;

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_GET_CONTA_DEPOSITO);

			stmt.setString(1, agencia);
			stmt.setString(2, numero);
			stmt.setString(3, titular);

			rs = stmt.executeQuery();

			while (rs.next()) {
				conta = (Conta) readResultSet(rs);
			}

			if (conta == null) {
				JOptionPane.showMessageDialog(null, "Conta não localizada!", "Atenção", JOptionPane.ERROR_MESSAGE);
			}
			return conta;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateSaldo(Conta conta, BigDecimal valorDeposito) {

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

	public void inativarConta(Conta conta) {

		con = Conexao.getConection();
		try {
			stmt = con.prepareStatement(SQL_INATIVAR);

			stmt.setInt(1, conta.getId());
			int linhasAtualizadas = stmt.executeUpdate();

			if (linhasAtualizadas == 0) {
				JOptionPane.showMessageDialog(null, "Conta não inativada", "Atenção", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Conta inativada com sucesso!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.close(null, stmt, con);
		}

	}

	public void insertMovimentacao(Movimentacao movimentacao) {

		try {
			con = Conexao.getConection();

			stmt = con.prepareStatement(SQL_INSERT_MOVIMENTAO, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, movimentacao.getOperacao());
			stmt.setTimestamp(2, new Timestamp(movimentacao.getData().getTime()));
			stmt.setBigDecimal(3, movimentacao.getValor());
			stmt.setString(4, movimentacao.getAgencia());
			stmt.setString(5, movimentacao.getConta());

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.close(null, stmt, con);

		}

	}

	public List<Movimentacao> buscarMovimentacoes(String numeroConta) {

		List<Movimentacao> movimentacoes = new ArrayList<>();

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_SELECT_ALL_MOVIMENTACAO);

			stmt.setString(1, numeroConta);

			rs = stmt.executeQuery();

			while (rs.next()) {

				Movimentacao movimentacao = new Movimentacao();
				movimentacao.setData(rs.getTimestamp("data"));
				movimentacao.setOperacao(rs.getString("operacao"));
				movimentacao.setValor(rs.getBigDecimal("valor"));
				movimentacao.setId(rs.getInt("id"));
				movimentacoes.add(movimentacao);

			}

			return movimentacoes;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.close(rs, stmt, con);
		}

		return movimentacoes;
	}

}
