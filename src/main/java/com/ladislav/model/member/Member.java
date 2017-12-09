package com.ladislav.model.member;

import com.ladislav.model.injury.Injury;
import java.util.List;

// TODO Builder pattern in member class?

public class Member {

  private int memberID;

  private String name;
  private String surname;

  //TODO use date objects
  private String birthDate;
  private String deathDate;

  private City city;

  private String phoneNumber;
  private String phoneNUmber2;

  private WorkStatus workStatus;
  private String educationDegree;
  private String proffesion;

  private HousingQuestion housingQuestion;

  private String maritialStatus;

  private InvalidityStatus invalidityStatus;

  //TODO add new table to database (Ladislav)
  private int invalidityLevel;
  private int invalidityDegree;

  private List<Injury> injuries;

  public int getMemberID() {
    return memberID;
  }

  //TODO override equals(), hashCode() and toString(), provide getters/setters when class is finished
}
