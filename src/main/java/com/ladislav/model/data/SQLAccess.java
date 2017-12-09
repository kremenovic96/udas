package com.ladislav.model.data;

import com.ladislav.model.injury.Injury;
import com.ladislav.model.injury.InjuryCause;
import com.ladislav.model.injury.InjuryPosition;
import com.ladislav.model.member.City;
import com.ladislav.model.member.CityProvince;
import com.ladislav.model.member.EducationLevel;
import com.ladislav.model.member.HousingQuestion;
import com.ladislav.model.member.InvalidityStatus;
import com.ladislav.model.member.Member;
import com.ladislav.model.member.Profession;
import com.ladislav.model.member.WorkStatus;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Frankensteins monster to access the data from DB.
 * Could be improved
 *
 * @author Ladislav
 */
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

    List<Member> members = new ArrayList<>();

    List<City> cities = queryCities();
    List<CityProvince> cityProvinces = queryCityProvinces();
    List<EducationLevel> educationLevels = queryEducationLevels();
    List<HousingQuestion> housingQuestions = queryHousingQuestions();
    List<InvalidityStatus> invalidityStatuses = queryInvalidityStatuses();
    List<Profession> professions = queryProfessions();
    List<WorkStatus> workStatuses = queryWorkStatuses();
    List<InjuryCause> injuryCauses = queryInjuryCauses();

    while (resultSet.next()) {

      int memberID = resultSet.getInt("clanID");
      String name = resultSet.getString("ime");
      String surname = resultSet.getString("prezime");
      String identityNumber = resultSet.getString("JMBG");
      String dateOfBirth = resultSet.getString("datumRodj");
      String phoneNumber1 = resultSet.getString("tel1");
      String phoneNumber2 = resultSet.getString("tel2");
      int cityID = resultSet.getInt("mjestoID");
      int cityProvinceID = resultSet.getInt("mjesnaZajID");
      String street = resultSet.getString("ulica");
      String homeNumber = resultSet.getString("brojStanaKuce");
      int peopleInHousehold = resultSet.getInt("clanoviDomacinstva");
      String dateOfDeath = resultSet.getString("datumSmrti");
      int educationLevelID = resultSet.getInt("stepenObrID");
      int professionID = resultSet.getInt("zanimanjeID");
      int workStatusID = resultSet.getInt("radniStatID");
      int injuryCauseID = resultSet.getInt("nacinPovrID");
      int invalidityStatusID = resultSet.getInt("statusInvID");
      int housingQuestionID = resultSet.getInt("stamPitID");
      String sex = resultSet.getString("pol");
      String comments = resultSet.getString("napomena");

      List<Injury> injuries = queryMembersInjuries(memberID);

      City city = cities
          .stream()
          .filter(e -> e.getCityID() == cityID)
          .findFirst()
          .orElseThrow(null);

      CityProvince cityProvince = cityProvinces
          .stream()
          .filter(e -> e.getCityProvinceID() == cityProvinceID)
          .findFirst()
          .orElse(null);

      EducationLevel educationLevel = educationLevels
          .stream()
          .filter(e -> e.getEducationLevelID() == educationLevelID)
          .findFirst()
          .orElseThrow(null);

      HousingQuestion housingQuestion = housingQuestions
          .stream()
          .filter(e -> e.getHousingQuestionID() == housingQuestionID)
          .findFirst()
          .orElseThrow(null);

      Profession profession = professions
          .stream()
          .filter(e -> e.getProfessionID() == professionID)
          .findFirst()
          .orElseThrow(null);

      WorkStatus workStatus = workStatuses
          .stream()
          .filter(e -> e.getWorkStatusID() == workStatusID)
          .findFirst()
          .orElseThrow(null);

      InvalidityStatus invalidityStatus = invalidityStatuses
          .stream()
          .filter(e -> e.getInvalidityStatusID() == invalidityStatusID)
          .findFirst()
          .orElseThrow(null);

      InjuryCause injuryCause = injuryCauses
          .stream()
          .filter(e -> e.getInjuryCauseID() == injuryCauseID)
          .findFirst()
          .orElseThrow(null);

      members.add
          (
              new Member
                  (
                      memberID,
                      name,
                      surname,
                      identityNumber,
                      dateOfBirth,
                      phoneNumber1,
                      phoneNumber2,
                      city,
                      cityProvince,
                      street,
                      homeNumber,
                      peopleInHousehold,
                      dateOfDeath,
                      educationLevel,
                      profession,
                      workStatus,
                      injuryCause,
                      invalidityStatus,
                      housingQuestion,
                      sex,
                      comments,
                      injuries
                  )
          );
    }

    return members;
  }

  public List<Profession> queryProfessions() throws SQLException {

    ResultSet results = executeQuery("SELECT * FROM zanimanje");

    List<Profession> professions = new ArrayList<>();
    while (results.next()) {
      professions.add(
          new Profession
              (
                  results.getInt("zanimanjeID"),
                  results.getString("zanimanje")
              )
      );
    }
    return professions;
  }


  public List<Injury> queryMembersInjuries(int clanID) throws SQLException {

    ResultSet results = executeQuery("SELECT * FROM povreda WHERE clanID =" + clanID);

    List<InjuryPosition> injuryPositions = queryInjuryPositions();
    List<Injury> injuries = new ArrayList<>();

    while (results.next()) {

      int injuryPositionID = results.getInt("mjestoPovrID");
      boolean amputated = results.getBoolean("amputacija");

      InjuryPosition injuryPosition = injuryPositions
          .stream()
          .filter(e -> e.getInjuryPositionID() == injuryPositionID)
          .findFirst()
          .orElse(null);

      injuries.add
          (
              new Injury
                  (
                      injuryPosition,
                      amputated
                  )
          );
    }

    return injuries;
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
                      results.getInt("statusInvID"),
                      results.getString("statusInv")
                  )
          );
    }
    return InvalidityStatus;
  }

  public List<HousingQuestion> queryHousingQuestions() throws SQLException {
    ResultSet results = executeQuery("SELECT * FROM stambenoPitanje");
    List<HousingQuestion> housingQuestions = new ArrayList<>();

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
    ResultSet results = executeQuery("SELECT * FROM mjesnaZajednica");
    List<CityProvince> cityProvinces = new ArrayList<>();

    while (results.next()) {
      cityProvinces.add
          (
              new CityProvince
                  (
                      results.getInt("mjesnaZajID"),
                      results.getString("mjesnaZajednica"),
                      results.getInt("mjestoID")
                  )
          );
    }
    return cityProvinces;
  }

  public List<InjuryCause> queryInjuryCauses() throws SQLException {
    ResultSet results = executeQuery("SELECT * FROM nacinPovrede");
    List<InjuryCause> injuryCauses = new ArrayList<>();

    while (results.next()) {
      injuryCauses.add
          (
              new InjuryCause
                  (
                      results.getInt("nacinPovrID"),
                      results.getString("nacinPovr")
                  )
          );
    }
    return injuryCauses;
  }

  public List<WorkStatus> queryWorkStatuses() throws SQLException {
    ResultSet results = executeQuery("SELECT * FROM radniStatus");
    List<WorkStatus> workStatuses = new ArrayList<>();

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

  public List<InjuryPosition> queryInjuryPositions() throws SQLException {
    ResultSet results = executeQuery("SELECT * FROM mjestoPovrede");
    List<InjuryPosition> injuryPositions = new ArrayList<>();

    while (results.next()) {
      injuryPositions.add
          (
              new InjuryPosition
                  (
                      results.getInt("mjestoPovrID"),
                      results.getString("mjestoPovr")
                  )
          );
    }
    return injuryPositions;
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
    access.getAllMembers().forEach(System.out::println);

  }

}

