package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntregrityException;

public class Main {

	public static void main(String[] args) {
	
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection(); // connectar com o banco
			st = conn.prepareStatement(   // aqui eu coloco o comando para atualizar os dados
				"DELETE FROM department "
				+ "WHERE "
				+ "Id = ? ");
				
					st.setInt(1, 2);
					int rowAffected = st.executeUpdate();
					System.out.println("Feito! Linhas afetadas: " + rowAffected);
		}catch(SQLException e) {
			throw new DbIntregrityException(e.getMessage());
		}finally {
			DB.closeConnection();
		}
			
	}
}