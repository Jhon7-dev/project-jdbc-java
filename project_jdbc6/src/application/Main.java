package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import db.DbIntregrityException;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;

		

		Statement st = null;
		try {
			conn = DB.getConnection(); // connectar com o banco
			st = conn.createStatement(); // aqui eu coloco o comando para atualizar os dados
			conn.setAutoCommit(false); // nao é para confirmar automaticamente
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1"); // todo vendedor
																										// do
																										// departamento
																										// 1 vai ganhar
																										// 2090
		//	int x = 1;
			//if (x < 2) {
				//throw new SQLException("Fake error");
			//}
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			conn.commit();

			System.out.println("Rows1 " + rows1);
			System.out.println("Rows2 " + rows2);
		} catch (SQLException e) {
			try {
				conn.rollback(); // se der um roll back, aconteceu um error e eu vou ter q informar
				throw new DbException("Transação errada! causada by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Transação errada! causada by: " + e.getMessage());

			} // vai voltar ao estado inicial do banco
		} finally {
			DB.closeConnection();
		}

	}
}