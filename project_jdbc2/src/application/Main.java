package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Main {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		/* A Classe Statement serve para montar o comando SQL para ser executado
		 * no caso *RECUPERAR OS DADOS*.
		 * 
		 * A Classe Resultset vai representar um objeto contendo o resultado da nossa
		 * consulta em forma de *tabela* */
		/* função first() -> posiciona na posição 1 */
		/* função beforeFirst()-> posiciona na posição zero, começo do ResultSet*/
		/* função next() -> ela vai para o próx, percorre o ResultSet. Restorna false se tiver
		 * no último.*/
		/* função absolute(int) -> ele vai posicionar  no ResultSet()*/
		
		
		try {
			conn = DB.getConnection(); //conectar ao banco de dados
			st = conn.createStatement(); // vou instanciá-la
			rs = st.executeQuery("select * from department"); // eu chamo o método executeQuery, ele espera que eu entre com uma String, um comando do SQL
			// o resultado dessa consulta vai ir para o rs, então eu atribuo rs ao st.excuteQuery()
					/*O rs vai ser o objeto que tem a tabela, por padrão começa na posição 0 e para percorrer, eu chamo a função next().*/
					/*OBS: o next() irá retornar falso se tiver em último lugar./
					 * 
					 */
					while(rs.next()) {
						/*getInt("id") para percorrer o inteiro e o getString para percorrer o nome*/
						System.out.println(rs.getInt("id") + " - " + rs.getString("Name"));
			}
		}
		catch(SQLException e ) {
			e.printStackTrace();
		}
		/*OBS: esses recursos precisam ser fechados manualmente para evitar vazamento de memória*/
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
}