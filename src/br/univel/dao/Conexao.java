package br.univel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {

	private static final String URL_BANCO = "jdbc:postgresql://localhost:5432/BancoCentral";
	private static final String USER = "postgres";
	private static final String PASS = "1";

	public static ResultSet rs;
	public Statement stmt;
	public Connection con;

	public static Connection getConection() {

		System.out.println("Conectando ao banco de dados");

		try {
			return DriverManager.getConnection(URL_BANCO, USER, PASS);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao conectar com o banco de dados. \n\n" + e,
					"Atenção", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}

	}

	public static void close(ResultSet set, Statement stmt, Connection conn) {
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
