package com.ladislav.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  public static final String URL = "jdbc:sqlserver://localhost";
  public static final String USER = "Lado";
  public static final String PASS = "lado";
  public static final String SQL_SERVER = "jdbc:sqlserver://localhost;databaseName=udas;";
  public static final String SQL_USER = "user=";
  public static final String SQL_PASSWORD = ";password=";
  /**
   * Get a connection to database
   *
   * @return Connection object
   */
  public static Connection getConnection(String username , String password) throws SQLException {

      String connectionUrl = SQL_SERVER + SQL_USER + username+ SQL_PASSWORD + password +";";
      return DriverManager.getConnection(connectionUrl);

  }


  public static Connection getConnection() throws SQLException {
    return getConnection(USER, PASS);
  }

  /**
   * Test Connection
   */
  public static void main(String[] args) throws SQLException {
    Connection connection = ConnectionFactory.getConnection();
    Connection connection2 = ConnectionFactory.getConnection("Lado", "lado");
  }
}

