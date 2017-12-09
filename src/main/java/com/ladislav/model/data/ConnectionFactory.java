package com.ladislav.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  public static final String URL = "jdbc:sqlserver://localhost";
  private static final String USER = "Lado";
  private static final String PASS = "lado";
  private static final String SQL_SERVER = "jdbc:sqlserver://localhost;databaseName=udas;";
  private static final String SQL_USER = "user=";
  private static final String SQL_PASSWORD = ";password=";

  /**
   * Get a connection to database, user must provide valid credentials - SQL Authentification is used
   *
   * @return Connection object
   */
  public static Connection getConnection(String username, String password) throws SQLException {

    String connectionUrl = SQL_SERVER + SQL_USER + username + SQL_PASSWORD + password + ";";
    return DriverManager.getConnection(connectionUrl);

  }

  /**
   * Temporary method used for testing purposes
   */
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

