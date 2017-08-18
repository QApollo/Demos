# OCA Demo Chapter 4

## Chapter 4
Chapter 4 Methods and Encapsulation.
Chapter 4 went over acces modification, Encapsulation, static members & methods, final members & methods.
Method overloading and lambda's

## QueryBuilder
For the demo of chapter 4 I made a conceptual querybuilder.
Since it is not actually functional but rather a way of showing how such a thing could be used.
Instead of writing raw SQL queries using a querybuilder is more inline with OOP paradigm.
The builder methods take arguments and constructs the query for you.

## Chapter 4 code snippets

```
String userID = "23";
    
    ArrayList<String> fields = new ArrayList<String>();
    fields.add("id");
    fields.add("userid");
    fields.add("amount");
    fields.add("date");

    QueryBuilder qb = new QueryBuilder();
    qb.table("payments")
      .select(fields)
      .where("userid", userID)
      .getAll();
      
      System.out.println(QueryBuilder.getLastQuery());
      System.out.println("Total queries executed: " + QueryBuilder.getQueryCount() + System.lineSeparator());
```
QueryBuilder in use + getting some static values
output is: `SELECT id, userid, amount, date FROM payments WHERE userid = 23;
Total queries executed: 1`

```
  public QueryBuilder select() {
    //this is the default select method which sets select to * (ALL)
    query.append("SELECT * FROM " + table_name + " ");
    return this;
  }

  public QueryBuilder select(String columns) {
    //here you can pass a single or multiple columns as string i.e. id, firstName, LastName, age
    query.append("SELECT " + columns + " FROM " + table_name + " ");
    return this;
  }

  public QueryBuilder select(ArrayList<String> columns) {
    /*in this select method you can pass an ArrayList containing all the columns you want to select from
    With a bit of looping we add a , and space after the columns. however the last , and space get deleted after the last item
    i.e without deletion: SELECT item0, item1, item2, FROM
    i.e with deletion: SELECT item0, item1, item2 FROM
    The first one in SQL would give an error trying to run the query
    */
    query.append("SELECT ");

    for(String column : columns) {
      query.append(column + ", ");
    }

    query.deleteCharAt(query.length() -2);
    query.append("FROM " + table_name + " ");

    return this;
  }
```
Select method overloading

```
public void getAll() {
    /*If this was actually connected to a database here you would execute the statement
    return the results object, clear the query and possibly other tasks you'd want to do
    before or after running the query
    */
    query.append(";");
    setLastQuery(query.toString());
    increaseQueryCount();
    clear();
    return;
  }

  private void clear() {
    query.setLength(0);
    table_name = "";
  }

  private static void setLastQuery(String query) {
    lastQuery = query;
  }
  
  public static String getLastQuery() {

    return lastQuery;
  }

  private void increaseQueryCount() {
    queryCount++;
  }

  public static int getQueryCount() {
    return queryCount;
  }
```
Encapsulation + static methods
