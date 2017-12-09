package com.ladislav.model.member;

import com.ladislav.model.injury.Injury;
import com.ladislav.model.injury.InjuryCause;
import java.util.List;

// TODO Builder pattern in member class?

public class Member {

  private CityProvince cityProvince;
  private String street;
  private String homeNumber;
  private int peopleInHousehold;
  private String sex;
  private String comments;
  private  int memberID;

  private String name;
  private String surname;
  private final String identityNumber;

  //TODO use date objects
  private String birthDate;
  private String deathDate;

  private City city;

  private String phoneNumber;
  private String phoneNUmber2;

  private WorkStatus workStatus;
  private EducationLevel educationLevel;
  private Profession proffesion;

  private HousingQuestion housingQuestion;

  private String maritialStatus;

  private InvalidityStatus invalidityStatus;

  //TODO add new table to database (Ladislav)
  private int invalidityLevel;
  private int invalidityDegree;

  InjuryCause injuryCause;
  private List<Injury> injuries;

  public Member(int memberID, String name, String surname,
      String identityNumber, String dateOfBirth, String phoneNumber1, String phoneNumber2,
      City city, CityProvince cityProvince, String street, String homeNumber, int peopleInHousehold,
      String dateOfDeath, EducationLevel educationLevel, Profession profession,
      WorkStatus workStatus, InjuryCause injuryCause, InvalidityStatus invalidityStatus,
      HousingQuestion housingQuestion, String sex, String comments, List<Injury> injuries) {


    this.memberID = memberID;
    this.name = name;
    this.surname = surname;
    this.identityNumber = identityNumber;
    this.birthDate = dateOfBirth;
    this.phoneNumber = phoneNumber1;
    this.phoneNUmber2 = phoneNumber2;
    this.city = city;
    this.cityProvince = cityProvince;
    this.street = street;
    this.homeNumber = homeNumber;
    this.peopleInHousehold = peopleInHousehold;
    this.deathDate = dateOfDeath;
    this.educationLevel = educationLevel;
    this.proffesion = profession;
    this.workStatus = workStatus;
    this.injuryCause = injuryCause;
    this.invalidityStatus = invalidityStatus;
    this.housingQuestion = housingQuestion;
    this.sex = sex;
    this.comments = comments;
    this.injuries = injuries;




  }

  public int getMemberID() {
    return memberID;
  }

  @Override
  public String toString() {
    return "Member{" +
        "cityProvince=" + cityProvince +
        ", street='" + street + '\'' +
        ", homeNumber='" + homeNumber + '\'' +
        ", peopleInHousehold=" + peopleInHousehold +
        ", sex='" + sex + '\'' +
        ", comments='" + comments + '\'' +
        ", memberID=" + memberID +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", identityNumber='" + identityNumber + '\'' +
        ", birthDate='" + birthDate + '\'' +
        ", deathDate='" + deathDate + '\'' +
        ", city=" + city +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", phoneNUmber2='" + phoneNUmber2 + '\'' +
        ", workStatus=" + workStatus +
        ", educationLevel=" + educationLevel +
        ", proffesion=" + proffesion +
        ", housingQuestion=" + housingQuestion +
        ", maritialStatus='" + maritialStatus + '\'' +
        ", invalidityStatus=" + invalidityStatus +
        ", invalidityLevel=" + invalidityLevel +
        ", invalidityDegree=" + invalidityDegree +
        ", injuryCause=" + injuryCause +
        ", injuries=" + injuries +
        '}';
  }

  //TODO override equals(), hashCode() and toString(), provide getters/setters when class is finished
}
