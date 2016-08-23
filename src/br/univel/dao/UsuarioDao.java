package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.univel.model.Usuario;

public class UsuarioDao {

	Connection con;
	private static String SQL_SELECT_ID = "SELECT * FROM USUARIO WHERE USUARIO = ? AND SENHA = ?";
	private static String SQL_INSERT = "INSERT INTO USUARIO (ID, USUARIO, SENHA,TIPOUSUARIO) VALUES (?,?,?,?)";

	public boolean acessoLogin(final String usuario, final String senha) {

		PreparedStatement stmt;
		try {
			con = Conexao.getConection();
			stmt = con.prepareStatement(SQL_SELECT_ID);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public void addUser(Usuario usuario) {

		con = Conexao.getConection();

		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setInt(1, usuario.getId());
			stmt.setString(2, usuario.getUsuario());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getTipoUsuario().toString());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
