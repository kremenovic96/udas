package com.ladislav.model.member;

import java.util.List;

// TODO Builder pattern in member class?

public class Member {

  private String name;
  private String surname;
  private String UID;
  private String birthDate;
  private String deathDate;

  private Address address;

  private String phoneNumber;
  private String phoneNUmber2;

  private WorkStatus workStatus;
  private String educationDegree;
  private String proffesion;

  private String housing;

  private String maritialStatus;

  private String invalidityStatus;
  private int invalidityLevel;
  private int invalidityDegree;

  private List<Injury> injuries;

  //TODO override equals(), hashCode() and toString(), provide getters/setters
}
