import java.sql.*;

public class SetupDerbyDB {
	public static void main(String[] args) throws Exception{
		String url = "jdbc:derby:java_exams;create=true";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			createExamStatTable(stmt);
		}	
	}
	
	private static void createExamStatTable(Statement stmt) throws SQLException {
		stmt.executeUpdate("CREATE TABLE oca_member ("
				+ "id INTEGER PRIMARY KEY, "
				+ "name VARCHAR(255), "
				+ "score INTEGER, "
				+ "exam_date DATE)");
				
		stmt.executeUpdate("INSERT INTO oca_member VALUES "
				+ "(1, 'Robbert', 85, '2017-06-01')");
		stmt.executeUpdate("INSERT INTO oca_member VALUES "
				+ "(2, 'John', 90, '2017-05-03')");
		stmt.executeUpdate("INSERT INTO oca_member VALUES "
				+ "(3, 'Nik', 71, '2017-01-11')");
		stmt.executeUpdate("INSERT INTO oca_member VALUES "
				+ "(4, 'Marcel', 88, '2017-01-11')");
	}
}