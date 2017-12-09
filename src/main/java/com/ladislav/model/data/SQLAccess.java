package com.ladislav.model.data;

import com.ladislav.model.member.City;
import com.ladislav.model.member.CityProvince;
import com.ladislav.model.member.EducationLevel;
import com.ladislav.model.member.HousingQuestion;
import com.ladislav.model.member.InvalidityStatus;
import com.ladislav.model.member.Member;
import com.ladislav.model.member.WorkStatus;
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


  public List<City> queryCities() throws SQLException {

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

  public List<EducationLevel> queryEducationLevels() throws SQLException {
    ResultSet results = executeQuery("SELECT * FROM stepenObrazovanja");
    List<EducationLevel> educationLevels = new ArrayList<>();

    while (results.next()) {
      educationLevels.add
          (
              new EducationLevel
                  (
                      results.getInt("stepenObrID"),
                      results.getString("stepenObr")
                  )
          );
    }
    return educationLevels;
  }

  public List<InvalidityStatus> queryInvalidityStatuses() throws SQLException {
    ResultSet results = executeQuery("SELECT * FROM statusInvalidnosti");
    List<InvalidityStatus> InvalidityStatus = new ArrayList<>();

    while (results.next()) {
      InvalidityStatus.add
          (
              new InvalidityStatus
                  (
                      results.getInt("statisInvID"),
                      results.getString("statusInv")
                  )
          );
    }
    return InvalidityStatus;
  }

  public List<HousingQuestion> queryHousingQuestions() throws SQLException {
    ResultSet results = executeQuery("SELECT * FROM stambenoPitanje");
    List<HousingQuestion> housingQuestions= new ArrayList<>();

    while (results.next()) {
      housingQuestions.add
          (
              new HousingQuestion
                  (
                      results.getInt("stambenoPitID"),
                      results.getString("stambenoPit")
                  )
          );
    }
    return housingQuestions;
  }

  public List<CityProvince> queryCityProvinces() throws SQLException {
    ResultSet results = executeQuery("SELECT * FROM stambenoPitanje");
    List<CityProvince> cityProvinces= new ArrayList<>();

    while (results.next()) {
      cityProvinces.add
          (
              new CityProvince
                  (
                      results.getInt("mjesnaZajID"),
                      results.getString("mjesnaZaj"),
                      results.getInt("mjestoID")
                  )
          );
    }
    return cityProvinces;
  }
  public List<WorkStatus> queryWorkStatuses() throws SQLException {
    ResultSet results = executeQuery("SELECT * FROM radniStatus");
    List<WorkStatus> workStatuses= new ArrayList<>();

    while (results.next()) {
      workStatuses.add
          (
              new WorkStatus
                  (
                      results.getInt("radniStatID"),
                      results.getString("radniStat")
                  )
          );
    }
    return workStatuses;
  }


  private ResultSet executeQuery(String query) throws SQLException {
    Statement statement = connection.createStatement();
    return statement.executeQuery(query);

  }

  private City queryCityFromID(int id) throws SQLException {
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


  public static void main(String[] args) throws SQLException {

    SQLAccess access = new SQLAccess("Lado", "lado");
    access.queryCities().forEach(System.out::println);

  }

}

