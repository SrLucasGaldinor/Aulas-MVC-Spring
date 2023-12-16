package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Contato;
import utils.Conexao;

public class DaoContato {
	
	public static boolean salvar(Contato contato) {
		Connection con = Conexao.getConexao();
		String sql = "INSERT INTO tb_contatos (nome, email) VALUES (?, ?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.execute();
		} catch (SQLException error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean editar(Contato contato) {
		Connection con = Conexao.getConexao();
		String sql = "UPDATE tb_contatos SET nome = ?, email = ? WHERE id = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setInt(3, contato.getId());
			stm.execute();
		} catch (SQLException error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static List<Contato> consultar() {
		Connection con = Conexao.getConexao();
		String sql = "SELECT * FROM tb_contatos";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			List<Contato> contatos = new ArrayList<Contato>();
			while(rs.next()) {
				contatos.add(new Contato(rs.getInt("id"),
										 rs.getString("nome"),
										 rs.getString("email")));
			}
			return contatos;
		} catch (Exception error) {
			error.printStackTrace();
		} finally {
			Conexao.fecharConexao();
		}
		return null;
	}
	
	public static Contato consultar(int id) {
		Connection con = Conexao.getConexao();
		String sql = "SELECT * FROM tb_contatos WHERE id = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			Contato contato = null;
			if(rs.next()) {
				contato = new Contato(rs.getInt("id"),
									  rs.getString("nome"),
									  rs.getString("email"));
			}
			return contato;
		} catch (Exception error) {
			error.printStackTrace();
		} finally {
			Conexao.fecharConexao();
		}
		return null;
	}
}
