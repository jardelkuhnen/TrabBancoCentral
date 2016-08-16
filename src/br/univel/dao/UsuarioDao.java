package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.univel.enun.TipoUsuario;

public class UsuarioDao {

	Connection con;

	public TipoUsuario acessoLogin(final String usuario, final String senha) {

		con = Conexao.getConection();

		String sql = "SELECT tipoUsuario FROM USUARIO WHERE USUARIO = ? AND SENHA = ?";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();

			int tipoUsuario = 0;
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
}
