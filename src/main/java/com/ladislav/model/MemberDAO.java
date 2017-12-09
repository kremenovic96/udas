package com.ladislav.model;

import java.util.List;

public interface MemberDAO {

  void createMember(Member member);

  void deleteMember(Member member);

  void updateMember(Member member);

  Member getMember(Member member);

  List<Member> getAllMembers();

}
