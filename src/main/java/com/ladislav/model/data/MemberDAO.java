package com.ladislav.model.data;

import com.ladislav.model.member.Member;
import java.sql.SQLException;
import java.util.List;

public interface MemberDAO {

  void createMember(Member member);

  boolean deleteMember(Member member) throws SQLException;

  void updateMember(Member member);

  Member getMember(Member member);

  List<Member> getAllMembers() throws SQLException;

}
