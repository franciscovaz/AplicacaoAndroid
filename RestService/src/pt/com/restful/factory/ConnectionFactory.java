package pt.com.restful.factory;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConnectionFactory {
	// caminho da BD
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/appperiodofertil";
	private static final String utilizador = "root";
	private static final String pass = "1234";

	public Connection criarConexao() {

		Connection conexao = null;

		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, utilizador, pass);
		} catch (Exception e) {
			System.out.println("Erro ao criar conexao com a BD:" + url);
			e.printStackTrace();
		}

		return conexao;

	}

	public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs) {

		try {
			if (conexao != null) {
				conexao.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexao com a BD:" + url);
		}

	}

}