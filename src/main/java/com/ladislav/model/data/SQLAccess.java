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


  public List<Member> getMembers(HashMap<String, String> searchParameters) {
    return null;
  }

  public List<Member> getAllMembers() throws SQLException {

    String query = " SELECT clanID, ime, prezime, JMBG, datumRodj, tel1, tel2, mjesto.mjesto,\n"
        + "        mjesnaZajednica.mjesnaZajednica, ulica, brojStanaKuce, clanoviDomacinstva, datumSmrti,\n"
        + "        stepenObrazovanja.stepenObr, zanimanje.zanimanje, radniStatus.radniStat, nacinPovrede.nacinPovr,\n"
        + "        statusInvalidnosti.statusInv, stambenoPitanje.stambenoPit, pol, napomena\n"
        + "    FROM clan\n"
        + "    LEFT JOIN mjesto ON mjesto.mjestoID = clan.clanID\n"
        + "    LEFT JOIN mjesnaZajednica ON mjesnaZajednica.mjesnaZajID = clan.mjesnaZajID\n"
        + "    LEFT JOIN stepenObrazovanja ON stepenObrazovanja.stepenObrID = clan.stepenObrID\n"
        + "    LEFT JOIN zanimanje ON zanimanje.zanimanjeID = clan.zanimanjeID\n"
        + "    LEFT JOIN radniStatus ON radniStatus.radniStatID = clan.radniStatID\n"
        + "    LEFT JOIN nacinPovrede ON nacinPovrede.nacinPovrID = clan.nacinPovrID\n"
        + "    LEFT JOIN statusInvalidnosti ON statusInvalidnosti.statusInvID = clan.statusInvID\n"
        + "    LEFT JOIN stambenoPitanje ON stambenoPitanje.stambenoPitID = clan.stamPitID";

    ResultSet resultSet = executeQuery(query);
    List<Member> members = new ArrayList<>();
    while (resultSet.next()) {

      int clanID = resultSet.getInt("clanID");
      String ime = resultSet.getString("ime");
      String prezime = resultSet.getString("prezime");
      String JMBG = resultSet.getString("JMBG");
      String datumRodj = resultSet.getString("datumRodj");
      String tel = resultSet.getString("tel1");
      String tel2 = resultSet.getString("tel2");
      String mjesto = resultSet.getString("mjesto");
      String mjesnaZajednica = resultSet.getString("mjesnaZajednica");
      String ulica = resultSet.getString("ulica");
      String brojStanaKuce = resultSet.getString("brojStanaKuce");
      int clanoviDom = resultSet.getInt("clanoviDomacinstva");
      String datumSmrti = resultSet.getString("datumSmrti");
      String stepenObr = resultSet.getString("stepenObr");
      String zanimanje = resultSet.getString("zanimanje");
      String radniStat = resultSet.getString("radniStat");
      String nacinPovr = resultSet.getString("nacinPovr");
      String statusInv = resultSet.getString("statusInv");
      String stambenoPit = resultSet.getString("stambenoPit");
      String pol = resultSet.getString("pol");
      String napomena = resultSet.getString("napomena");

      List<Injury> povrede = getInjuries(clanID);

          members.add(
              new Member(clanID, ime, prezime, JMBG, datumRodj, tel, tel2, mjesto, mjesnaZajednica,
                  ulica, brojStanaKuce, clanoviDom, datumSmrti, stepenObr, zanimanje, radniStat,
                  nacinPovr,
                  statusInv, stambenoPit, pol, napomena, povrede));
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
        + "SELECT mjestoPovrede.mjestoPovr, amputacija\n"
        + "FROM povreda\n"
        + "LEFT JOIN mjestoPovrede ON mjestoPovrede.mjestoPovrID = povreda.mjestoPovrID\n"
        + "WHERE clanID =" + id);

    while (resultSet.next()) {

      String povreda = resultSet.getString("mjestoPovr");
      boolean amputacija = resultSet.getBoolean("amputacija");

      injuries.add(new Injury(povreda, amputacija));

    }

    return injuries;
  }

  public static void main(String[] args) throws SQLException {

//    SQLAccess access = new SQLAccess("Lado", "lado");
//    access.getAllMembers().forEach(System.out::println);

  }

}

