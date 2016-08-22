package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.univel.controller.UsuarioController;
import br.univel.enun.TipoUsuario;
import br.univel.model.Usuario;

public class UsuarioDao {

	Connection con;
	private static String sql = "SELECT tipoUsuario FROM USUARIO WHERE USUARIO = ? AND SENHA = ?";

	public TipoUsuario acessoLogin(final String usuario, final String senha) {
		con = Conexao.getConection();

		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();

			int tipoUsuario = 2;
			while (rs.next()) {

				tipoUsuario = Integer.parseInt(rs.getString("tipoUsuario"));
			}

			switch (tipoUsuario) {
			case 0:
				return TipoUsuario.CLIENTE;
			case 1:
				return TipoUsuario.BANCARIO;
			default:
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void addUser(Usuario usuario) {

		con = Conexao.getConection();

		String sql = "INSERT INTO USUARIO (ID, USUARIO, SENHA TIPOUSUARIO) VALUES (?,?,?,?)";

		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, usuario.getId());
			stmt.setString(2, usuario.getUsuario());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getTipoUsuario().toString());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null,
					"Usuario cadastrado com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
