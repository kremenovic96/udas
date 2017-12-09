package com.ladislav.model;

import com.ladislav.model.member.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.sql.Connection;


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


  public static void main(String[] args) throws SQLException {

//    SQLAccess access = new SQLAccess("Lado", "lado");
//
//    access.getAllMembers();

    String a = "name-name-name";
    System.out.println(a.matches("[a-zA-Z-]+"));
  }



  }

