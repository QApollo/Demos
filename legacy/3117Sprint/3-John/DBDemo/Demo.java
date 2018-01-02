import java.sql.*;
import java.util.stream.*;
import java.time.*;
import java.util.*;

public class Demo {
	public static void main(String[] args) {
		displayOcaTable();
	}
	
	static class Entry {
		public String name;
		public LocalDate date;
		public int score;
	}
	
	static void displayOcaTable() {
		String url = "jdbc:derby:java_exams";
		try (Connection conn = DriverManager.getConnection(url);
					Statement st = conn.createStatement(
							ResultSet.TYPE_FORWARD_ONLY,
							ResultSet.CONCUR_READ_ONLY)) {
			String sql = "SELECT name, exam_date, score FROM oca_member";
			ResultSet rset = st.executeQuery(sql);
			
			List<Entry> table = new ArrayList<>();
			
			while(rset.next()) {
				table.add(readEntry(rset));
			}
			
			displayEntries(table);
			
		} catch (SQLException e) {
			System.out.println("Houston, " + e.getMessage());
			System.exit(13);
		}
	}
	
	static Entry readEntry(ResultSet rset) throws SQLException {
		Entry e = new Entry();
		
		e.name = rset.getString("name");
		e.date = rset.getDate("exam_date").toLocalDate();
		e.score = rset.getInt("score");
		return e;
	}
	
	static void displayEntries(List<Entry> table) {
		StringJoiner joiner = new StringJoiner("\n");
		String border = "=================================";
		joiner.add(border);
		
		joiner.add(String.format("| %8s %7s %12s |", "name", "score", "date"));
		joiner.add("|-------------------------------|");
		
		
		String template = "| %8s %7d %12s |";
		for (Entry e : table) {
			joiner.add(String.format(template, e.name, e.score, e.date.toString()));
		}
		joiner.add(border);
		
		System.out.println(joiner.toString());
	}
	
}