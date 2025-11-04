package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import db.DB;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection(); // connectar com o banco
			// o conn ele espera uma string de inserção de dados
			st = conn.prepareStatement(
					"INSERT INTO seller" + "(Name,EMail,BirthDate,BaseSalary,DepartmentId)" + "VALUES"
							+ "(?,?,?,?,?)", /* PLACEHOLDER,lugar onde eu irei colocar os valores */
					Statement.RETURN_GENERATED_KEYS);
			// agora, para adicionar os valores nas "?", que equivalem a
			// "Name,EMail,BirthDate,BaseSalary,DepartmentId"
			st.setString(1, "João Victor");
			st.setString(2, "joao021@icloud");
			st.setDate(3, new java.sql.Date(sdf.parse("27/08/2003").getTime()));
			st.setDouble(4, 12.900);
			st.setInt(5, 4);

			int rowAffected = st.executeUpdate();
			if (rowAffected > 0) {
				ResultSet rs = st.getGeneratedKeys(); // gera um ResultSet
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Feito! Id = " + id);
				}
				
			} else {
				System.out.println("Sem linhas afetadas!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.closeConnection();

		}
	}
}