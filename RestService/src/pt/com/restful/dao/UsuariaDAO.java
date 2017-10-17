package pt.com.restful.dao;

import pt.com.restful.model.Usuaria;
import pt.com.restful.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuariaDAO extends ConnectionFactory{

	private static UsuariaDAO instance;

	public static UsuariaDAO getInstance() {
		if (instance == null)
			instance = new UsuariaDAO();

		return instance;
	}

	public ArrayList<Usuaria> listarTodas() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Usuaria> usuarias = null;

		conexao = criarConexao();
		usuarias = new ArrayList<Usuaria>();

		try {
			pstmt = conexao.prepareStatement("select * from usuaria");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Usuaria usuaria = new Usuaria();

				usuaria.setIdLogin(rs.getInt("idLogin"));
				usuaria.setNomeUtilizadora(rs.getString("nomeUtilizadora"));
				usuaria.setTelUtilizadora(rs.getInt("telUtilizadora"));

				usuarias.add(usuaria);
			}
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os clientes: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}

		return usuarias;
	}

	
	public void inserirUsuaria(Usuaria usuaria) throws SQLException {

		Connection conexao = null;

		conexao = criarConexao();
		ResultSet rs = null;

		PreparedStatement pstmt = conexao.prepareStatement("INSERT INTO login (tipoDeUtilizador, email, password) VALUES(?,?,?)");
		pstmt.setString(1, usuaria.getTipoDeUtilizador());
		pstmt.setString(2, usuaria.getEmail());
		pstmt.setString(3, usuaria.getPassword());

		pstmt.executeUpdate();

		pstmt.close();

		PreparedStatement pstmt1 = conexao.prepareStatement("SELECT idLogin FROM login WHERE email = ?");
		pstmt1.setString(1, usuaria.getEmail());
		rs = pstmt1.executeQuery();
		rs.next();
		usuaria.setIdLogin(rs.getInt("idLogin"));

		pstmt1.close();

		PreparedStatement pstmt2 = conexao.prepareStatement("INSERT INTO usuaria(nomeUtilizadora,telUtilizadora,Login_idLogin) VALUES(?,?,?)");
		pstmt2.setString(1, usuaria.getNomeUtilizadora());
		pstmt2.setInt(2, usuaria.getTelUtilizadora());
		pstmt2.setInt(3, usuaria.getIdLogin());

		pstmt2.executeUpdate();

		pstmt2.close();

		conexao.close();

	}

}
