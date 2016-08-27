package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.univel.model.Conta;

public class ContaDao {

	private static final String SQL_INSERT = "INSERT INTO CONTA (NOME, IDADE, CPF, AGENCIA, TIPOCONTA, SENHAACESSO, SENHAOPERACOES, NUMEROCONTA) VALUES (?,?,?,?,?,?,?,?)";
	
	public void add(Conta conta) {

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
		}

	}

	private void writeStatemento(Conta conta, PreparedStatement stmt) throws SQLException {

		stmt.setString(1, conta.getNome());
		stmt.setInt(2, conta.getIdade());
		stmt.setInt(3, conta.getCpf());
		stmt.setString(4, conta.getAgencia());
		stmt.setString(5, conta.getTipoConta().toString());
		stmt.setString(6, conta.getSenhaAcesso());
		stmt.setString(7, conta.getSenhaOperacoes());
		stmt.setInt(8, conta.getNumeroConta());
	}

}
