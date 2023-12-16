package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection con = null;
	
	public static Connection getConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aulas-atrasadas", "root", "290427");
		} catch(ClassNotFoundException | SQLException error){
			error.printStackTrace();
		}
		return con;
	}
	
	public static void fecharConexao() {
		try {
			con.close();
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}
}