package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

	Connection con;

	public boolean acessoLogin(final String usuario, final String senha) {

		try {
			con = Conexao.getConection();

			String sql = "SELECT USUARIO, SENHA FROM USUARIO WHERE USUARIO = ? AND SENHA = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}
