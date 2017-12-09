package com.ladislav.model.data;

import com.ladislav.model.member.City;
import com.ladislav.model.member.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class SQLAccess implements MemberDAO {

  Connection connection;

  public SQLAccess(String username, String password) throws SQLException {
    connection = ConnectionFactory.getConnection(username, password);
  }


  public void createMember(Member member) {

  }

  public boolean deleteMember(Member member) throws SQLException {
    ResultSet resultSet = executeQuery("DELETE FROM clan where clanID = " + member.getMemberID());
    return resultSet.next();
  }

  public void updateMember(Member member) {

  }

  public Member getMember(Member member) {
    return null;
  }

  public List<Member> getAllMembers() throws SQLException {

    ResultSet resultSet = executeQuery("SELECT * FROM clan");

    while (resultSet.next()) {
      System.out.println(resultSet.getString(2));
    }

    throw new NotImplementedException();

  }


  private City getCityFromID(int id) throws SQLException {
    ResultSet resultSet = executeQuery("SELECT * FROM mjesto WHERE mjestoID = " + id);

    if (!resultSet.next()) {
      return null;
    }

    return new City
        (
            resultSet.getInt("mjestoID"),
            resultSet.getString("mjesto"),
            resultSet.getInt("postanski_broj")
        );
  }

  public List<City> getAllCities() throws SQLException {

    ResultSet results = executeQuery("SELECT * FROM mjesto");

    List<City> cities = new ArrayList<>();
    while (results.next()) {
      cities.add(
          new City
              (
                  results.getInt("mjestoID"),
                  results.getString("mjesto"),
                  results.getInt("postanski_broj")
              )
      );
    }
    return cities;
  }


  private ResultSet executeQuery(String query) throws SQLException {
    Statement statement = connection.createStatement();
    return statement.executeQuery(query);

  }

  public static void main(String[] args) throws SQLException {

    SQLAccess access = new SQLAccess("Lado", "lado");
    access.getAllCities().forEach(System.out::println);

  }

}

