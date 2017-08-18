import builder.QueryBuilder;
import java.util.*;

public class Demo {
  public static void main(String[] args) {
    Demo dm = new Demo();
    QueryBuilder qb = new QueryBuilder();

    dm.getPaymentsByUserId(qb,22);
    Demo.printLastQuery();
    Demo.printQueryCount();

    dm.getAllUsers(qb);
    Demo.printLastQuery();
    Demo.printQueryCount();

    dm.getAllPaymentsByAmount(qb);
    Demo.printLastQuery();
    Demo.printQueryCount();

  }


  //in a real life scenerio this would most likely return the result of the query
  private void getPaymentsByUserId(QueryBuilder qb, int userID) {
    ArrayList<String> fields = new ArrayList<String>();
    fields.add("id");
    fields.add("userid");
    fields.add("amount");
    fields.add("date");

    qb.table("payments")
      .select(fields)
      .where("userid", userID)
      .getAll();
  }

  //in a real life scenerio this would most likely return the result of the query
  private void getAllUsers(QueryBuilder qb) {
    qb.table("users")
      .select()
      .getAll();
  }

  //in a real life scenerio this would most likely return the result of the query
  private void getAllPaymentsByAmount(QueryBuilder qb) {
    qb.table("payments")
      .select()
      .where("amount", ">", 10)
      .getAll();
  }

  private static void printLastQuery() {
    System.out.println("Last query executed was: " + QueryBuilder.getLastQuery());
  }

  private static void printQueryCount() {
    System.out.println("Total queries executed: " + QueryBuilder.getQueryCount() + System.lineSeparator());;
  }

}
