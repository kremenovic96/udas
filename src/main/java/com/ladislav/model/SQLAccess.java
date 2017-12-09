package com.ladislav.model;

import com.ladislav.model.member.City;
import com.ladislav.model.member.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SQLAccess implements MemberDAO {

  Connection connection;

  public SQLAccess(String username, String password) throws SQLException {
    connection = ConnectionFactory.getConnection(username, password);
  }


  public void createMember(Member member) {

  }

  public void deleteMember(Member member) {

  }

  public void updateMember(Member member) {

  }

  public Member getMember(Member member) {
    return null;
  }

  public List<Member> getAllMembers() {
    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM clan");

      while (resultSet.next()) {
        System.out.println(resultSet.getString(2));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  public List<City> getAllCities() {
    Statement statement = null;
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM mjesto");

      List<City> cities = new ArrayList<>();

      while (resultSet.next()) {
        cities.add(
            new City
                (
                    resultSet.getInt("mjestoID"),
                    resultSet.getString("mjesto"),
                    resultSet.getInt("postanski_broj")
                )
        );
      }

      return cities;


    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }


  public static void main(String[] args) throws SQLException {

//    SQLAccess access = new SQLAccess("Lado", "lado");
//
//    access.getAllMembers();

    String a = "name-name-name";
    System.out.println(a.matches("[a-zA-Z-]+"));
  }

}

