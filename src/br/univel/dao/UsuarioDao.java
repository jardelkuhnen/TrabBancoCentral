package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.univel.model.Conta;
import br.univel.model.Usuario;

public class UsuarioDao {

	private static String SQL_SELECT_ID = "SELECT * FROM USUARIO WHERE USUARIO = ? AND SENHA = ? AND SITUACAO = 'ATIVO'";
	private static String SQL_INSERT = "INSERT INTO USUARIO (USUARIO, SENHA,TIPOUSUARIO, SITUACAO) VALUES (?,?,?,?)";
	private static String SQL_UPDATE = "UPDATE USUARIO SET USUARIO = ?, SENHA = ?, TIPOUSUARIO = ? WHERE ID = ? AND SITUACAO = 'ATIVO'";
	private static String SQL_INATIVAR_USUARIO = "UPDATE USUARIO SET SITUACAO = 'INATIVO' WHERE USUARIO = ?";

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	public boolean acessoLogin(final String usuario, final String senha) {

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_SELECT_ID);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();

			while (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.close(rs, stmt, con);
		}
		return false;

	}

	public void add(Usuario usuario) {

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_INSERT,
					Statement.RETURN_GENERATED_KEYS);
			writeStatement(usuario, stmt);

			int linhasInseridas = stmt.executeUpdate();
			if (linhasInseridas == 0) {
				throw new RuntimeException(
						"Falha ao inserir dados na tabela Usuário");
			}

			rs = stmt.getGeneratedKeys();
			rs.next();
			usuario.setId(rs.getInt(1));
			JOptionPane.showMessageDialog(null,
					"Usuário cadastrado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.close(rs, stmt, con);
		}

	}

	public void edit(Usuario usuario, Integer id) {

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_UPDATE);

			writeStatement(usuario, stmt);
			stmt.setInt(4, id);

			Integer linhasAtualizadas = stmt.executeUpdate();
			if (linhasAtualizadas == 0) {
				throw new RuntimeException("Registro não foi atualizado");
			}
			JOptionPane.showMessageDialog(null, "Usuário editado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.close(null, stmt, con);
		}

	}

	private void writeStatement(Usuario usuario, PreparedStatement stmt)
			throws SQLException {
		stmt.setString(1, usuario.getUsuario());
		stmt.setString(2, usuario.getSenha());
		stmt.setString(3, usuario.getTipoUsuario().toString());
		stmt.setString(4, usuario.getSituacaoBancaria());
	}

	public void inativarConta(Conta conta) {

		con = Conexao.getConection();

		try {
			stmt = con.prepareStatement(SQL_INATIVAR_USUARIO);

			stmt.setString(1, conta.getUsuarioAcesso());

			int linhasAtualizadas = stmt.executeUpdate();

			if (linhasAtualizadas == 0) {
				JOptionPane.showMessageDialog(null,
						"Erro ao inativar usuario!", "Atenção",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"Usuario inativado com suscesso");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.close(null, stmt, con);
		}

	}

}
