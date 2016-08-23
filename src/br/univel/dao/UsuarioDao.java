package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.univel.model.Usuario;

public class UsuarioDao {

	Connection con;
	private static String SQL_SELECT_ID = "SELECT * FROM USUARIO WHERE USUARIO = ? AND SENHA = ?";
	private static String SQL_INSERT = "INSERT INTO USUARIO (ID, USUARIO, SENHA,TIPOUSUARIO) VALUES (?,?,?,?)";
	private static String SQL_UPDATE = "UPDATE USUARIO SET USUARIO = ?, SENHA = ?, TIPOUSUARIO = ? WHERE ID = ?";
	private static String SQL_DELETE = "DELETE FROM USUARIO WHERE ID = ?";

	public boolean acessoLogin(final String usuario, final String senha) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
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
			close(rs, stmt, con);
		}
		return false;

	}

	public void add(Usuario usuario) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs;
		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			writeStatement(usuario, stmt);

			int linhasInseridas = stmt.executeUpdate();
			if (linhasInseridas == 0) {
				throw new RuntimeException("Falha ao inserir dados na tabela Usuário");
			}
			rs = stmt.getGeneratedKeys();
			rs.next();
			usuario.setId(rs.getInt(1));
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, stmt, con);
		}

	}

	public void edit(Usuario usuario, Integer id) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_UPDATE);

			stmt.setInt(4, id);
			Integer linhasAtualizadas = stmt.executeUpdate();
			if (linhasAtualizadas == 0) {
				throw new RuntimeException("Registro não foi atualizado");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, stmt, con);
		}

	}

	public void remove(Integer id) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			Integer linhasDeletadas = stmt.executeUpdate();
			if (linhasDeletadas == 0) {
				throw new RuntimeException("Registro não foi deletado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, stmt, con);
		}
	}

	private void writeStatement(Usuario usuario, PreparedStatement stmt) throws SQLException {
		stmt.setInt(1, usuario.getId());
		stmt.setString(2, usuario.getUsuario());
		stmt.setString(3, usuario.getSenha());
		stmt.setString(4, usuario.getTipoUsuario().toString());
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
