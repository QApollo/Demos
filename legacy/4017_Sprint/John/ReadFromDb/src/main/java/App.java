import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class App {

    static class Entry {
        public String name;
        public LocalDate date;
        public int score;
    }

    public void run() {
        String url = "jdbc:postgresql://0.0.0.0:32768/";
        try (Connection conn = DriverManager.getConnection(url,"docker", "docker");
             Statement st = conn.createStatement(
                     ResultSet.TYPE_FORWARD_ONLY,
                     ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT name, score, exam_date FROM exams ORDER BY exam_date;";
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
