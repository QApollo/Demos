package builder;

import java.util.*;
import java.nio.*;

public class QueryBuilder {
  private StringBuilder query = new StringBuilder("");
  private String table_name;
  private static int queryCount = 0;
  private static String lastQuery;

  public QueryBuilder() {
    //here you could connect a DB in this demo there is no DB connected
  }


  /*----------------DB functions--------------------*/
  public QueryBuilder table(String table_name) {
    //this function sets the table for your query
    this.table_name = table_name;
    return this;
  }

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

  public QueryBuilder where(String column, String value) {
    //Simply append where with the column and value you want to compare
    query.append("WHERE " + column + " = " + value);
    return this;
  }

  public QueryBuilder where(String column, String operator ,String value) {
    //overloaded where were you would pass it an other operator
    query.append("WHERE " + column + " " + operator + " " + value + " ");
    return this;
  }

  public QueryBuilder raw(String rawQuery) {
    /* Since sometimes you want to write a straight raw SQL query there is a raw method
    That is what this method is for incase the builder doesn't have the needed functions
    or the way it appeneds certain things does not align with how you need it
    */

    query.append(rawQuery);
    return this;
  }

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


  /*-----------Management func-------------*/
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






}
