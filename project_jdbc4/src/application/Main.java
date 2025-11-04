package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Main {

	public static void main(String[] args) {
	
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection(); // connectar com o banco
			st = conn.prepareStatement(   // aqui eu coloco o comando para atualizar os dados
					
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE  "
					+"(DepartmentId = ?)");
			
					st.setDouble(1, 700.00);
					st.setInt(2, 2);
					st.setDouble(1, 1345.0);
					st.setInt(2, 4);
					int rowAffected = st.executeUpdate();
					System.out.println("Feito! Linhas afetadas: " + rowAffected );
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {
			DB.closeConnection();
			DB.closeConnection();
		}
			
	}
}