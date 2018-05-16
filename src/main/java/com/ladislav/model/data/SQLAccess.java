package com.ladislav.model.data;

import com.ladislav.model.member.Injury;
import com.ladislav.model.member.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Frankensteins monster to access the data from DB. Should be improved
 *
 * @author Ladislav
 */
public class SQLAccess implements MemberDAO {

  Connection connection;

  public SQLAccess(String username, String password) throws SQLException {
    connection = ConnectionFactory.getConnection();
  }

  public void createMember(Member member) throws SQLException {
    executeQuery("INSERT INTO clan (ime, prezime, jmbg, datum_rodj"
            +", tel1, tel2, id_mjesto, id_mjesna, ulica, broj_stana_kuce, broj_clanova, datum_smrti"
            +", id_stepen_obr, id_zanimanje, id_radni_status, id_nacin_povrd)"
            +"VALUES ("+ member.nameProperty()+", "+member.surnameProperty()+", "
            +member.identityNumberProperty()+", "+member.birthDateProperty()+", "+member.phoneNumberProperty()
            +", "+member.phoneNumber2Property()+", "+member.cityProperty()+", "+member.cityProvinceProperty()
            +", "+member.streetProperty()+", "+member.homeNumberProperty()+", "+member.getPeopleInHousehold()
            +", "+member.deathDateProperty()+", "+member.educationLevelProperty()+", "+member.proffesionProperty()
            +", "+member.getWorkStatus()+", "+member.injuryCauseProperty()+");");
  }

  public boolean deleteMember(Member member) throws SQLException {
    ResultSet resultSet = executeQuery("DELETE FROM clan where id_clan = " + member.getMemberID());
    return resultSet.next();
  }

  public void updateMember(Member member) {

  }

  public Member getMember(Member member) throws SQLException{
    ResultSet resultSet = executeQuery("SELECT * FROM clan WHERE clanID = " + member.getMemberID()+";");
    return null;
  }


  public List<Member> getMembers(HashMap<String, String> searchParameters) {
    return null;
  }

  public List<Member> getAllMembers() throws SQLException {

    String query = " SELECT id_clan, ime, prezime, JMBG, datum_rodjenja, tel1, tel2, mjesto.mjesto,\n"
        + "        mjesna_zajednica.mjesna_zajednica, ulica, broj_stana_kuce, clanovi_domacinstva, datum_smrti,\n"
        + "        stepen_obrazovanja.stepen_obrazovanja, zanimanje.zanimanje, radni_status.radni_status, nacin_povrede.nacin_povrede,\n"
        + "        status_invalidnosti.status_invalidnosti, stambeno_pitanje.stambeno_pitanje, pol, napomena\n"
        + "    FROM clan\n"
        + "    LEFT JOIN mjesto ON mjesto.id_mjesto = clan.id_clan\n"
        + "    LEFT JOIN mjesna_zajednica ON mjesna_zajednica.id_mjesna_zajednica = clan.id_mjesna\n"
        + "    LEFT JOIN stepen_obrazovanja ON stepen_obrazovanja.id_stepen_obrazovanja = clan.id_stepen_obr\n"
        + "    LEFT JOIN zanimanje ON zanimanje.id_zanimanje = clan.id_zanimanje\n"
        + "    LEFT JOIN radni_status ON radni_status.id_radni_status = clan.id_radni_status\n"
        + "    LEFT JOIN nacin_povrede ON nacin_povrede.nacin_povrede = clan.id_nacin_povrd\n"
        + "    LEFT JOIN status_invalidnosti ON status_invalidnosti.id_status_invalidnosti = clan.id_status_invalidnosti\n"
        + "    LEFT JOIN stambeno_pitanje ON stambeno_pitanje.id_stambeno_pitanje = clan.id_stambeno_pitanje;";

    ResultSet resultSet = executeQuery(query);
    List<Member> members = new ArrayList<>();
    while (resultSet.next()) {

      int clanID = resultSet.getInt("id_clan");
      String ime = resultSet.getString("ime");
      String prezime = resultSet.getString("prezime");
      String JMBG = resultSet.getString("JMBG");
      String datum_rodjenja = resultSet.getString("datum_rodjenja");
      String tel = resultSet.getString("tel1");
      String tel2 = resultSet.getString("tel2");
      String mjesto = resultSet.getString("mjesto");
      String mjesna_zajednica = resultSet.getString("mjesna_zajednica");
      String ulica = resultSet.getString("ulica");
      String broj_stana_kuce = resultSet.getString("broj_stana_kuce");
      int clanoviDom = resultSet.getInt("clanovi_domacinstva");
      String datum_smrti = resultSet.getString("datum_smrti");
      String stepen_obrazovanja = resultSet.getString("stepen_obrazovanja");
      String zanimanje = resultSet.getString("zanimanje");
      String radni_status = resultSet.getString("radni_status");
      String nacin_povr = resultSet.getString("nacin_povrede");
      String status_inv = resultSet.getString("status_invalidnosti");
      String stambeno_pitanje = resultSet.getString("stambeno_pitanje");
      String pol = resultSet.getString("pol");
      String napomena = resultSet.getString("napomena");

      List<Injury> povrede = getInjuries(clanID);

          members.add(
              new Member(clanID, ime, prezime, JMBG, datum_rodjenja, tel, tel2, mjesto, mjesna_zajednica,
                  ulica, broj_stana_kuce, clanoviDom, datum_smrti, stepen_obrazovanja, zanimanje, radni_status,
                  nacin_povr,
                  status_inv, stambeno_pitanje, pol, napomena, povrede));
    }

    return members;
  }

  private ResultSet executeQuery(String query) throws SQLException {
    Statement statement = connection.createStatement();
    return statement.executeQuery(query);

  }

  private List<Injury> getInjuries(int id) throws SQLException {

    List<Injury> injuries = new ArrayList<>();

    ResultSet resultSet = executeQuery("\n"
        + "SELECT mjesto_povrede.mjesto_povrede, amputacija\n"
        + "FROM povreda\n"
        + "LEFT JOIN mjesto_povrede ON mjesto_povrede.id_mjesto_povrede = povreda.id_mjesto_povrede\n"
        + "WHERE id_clan =" + id);

    while (resultSet.next()) {

      String povreda = resultSet.getString("mjesto_povrede");
      boolean amputacija = resultSet.getBoolean("amputacija");

      injuries.add(new Injury(povreda, amputacija));

    }

    return injuries;
  }

  public static void main(String[] args) throws SQLException {

    SQLAccess access = new SQLAccess("Lado", "lado");
    access.getAllMembers().forEach(System.out::println);

  }

}

