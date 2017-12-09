package com.ladislav.model.member;

public class Profession {

  private final int professionID;
  private final String profession;

  public Profession(int professionID, String profession) {
    this.professionID = professionID;
    this.profession = profession;
  }

  public int getProfessionID() {
    return professionID;
  }

  public String getProfession() {
    return profession;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Profession that = (Profession) o;

    return professionID == that.professionID && profession.equals(that.profession);
  }

  @Override
  public int hashCode() {
    int result = professionID;
    result = 31 * result + profession.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Profession{" +
        "professionID=" + professionID +
        ", profession='" + profession + '\'' +
        '}';
  }
}
