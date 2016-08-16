package br.univel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	private static final String url_Banco = "jdbc:h2:~/BancoCentral";
	private static final String driver_Class = "org.h2.Driver";
	private static final String user = "sa";
	private static final String pass = "sa";

	public static ResultSet rs;
	public Statement stmt;
	public Connection con;

	public static Connection getConection() {

		System.out.println("Conectando ao banco de dados");

		try {
			Class.forName(driver_Class);
			return DriverManager.getConnection(url_Banco, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;

	}

}
