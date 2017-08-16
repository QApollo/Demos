import builder.QueryBuilder;
import java.util.*;

public class Demo {
  public static void main(String[] args) {

    ArrayList<String> fields = new ArrayList<String>();
    fields.add("id");
    fields.add("userid");
    fields.add("amount");
    fields.add("date");

    String userID = "23";

    QueryBuilder qb = new QueryBuilder();

    qb.table("payments")
      .select(fields)
      .where("userid", userID)
      .getAll();

      System.out.println(QueryBuilder.getLastQuery());
      System.out.println("Total queries executed: " + QueryBuilder.getQueryCount() + System.lineSeparator());


      qb.table("users")
        .select()
        .getAll();

        System.out.println(QueryBuilder.getLastQuery());
        System.out.println("Total queries executed: " + QueryBuilder.getQueryCount() + System.lineSeparator());

      qb.table("payments")
        .select()
        .where("amount",">","10")
        .getAll();

      System.out.println(QueryBuilder.getLastQuery());
      System.out.println("Total queries executed: " + QueryBuilder.getQueryCount() + System.lineSeparator());;

  }
}
