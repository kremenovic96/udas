package com.ladislav.model;

import com.ladislav.model.member.Member;
import java.util.List;

public interface MemberDAO {

  void createMember(Member member);

  void deleteMember(Member member);

  void updateMember(Member member);

  Member getMember(Member member);

  List<Member> getAllMembers();

}
