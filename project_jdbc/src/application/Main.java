package application;

import java.sql.Connection;

import db.DB;

public class Main {
	public static void main(String[] args) {
		Connection conn = DB.getConnection(); // quando eu quiser conectar com o banco é só chamar Db.getConncetion();
		if(conn!=null) {
			System.out.println("connectado");
		}
		DB.closeConnection();	
	}

}