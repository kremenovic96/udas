package com.ladislav.model.member;

public class EducationLevel {

  private final int educationLevelID;
  private final String educationlevel;

  public EducationLevel(int educationLevelID, String educationlevel) {
    this.educationLevelID = educationLevelID;
    this.educationlevel = educationlevel;
  }

  public int getEducationLevelID() {
    return educationLevelID;
  }

  public String getEducationlevel() {
    return educationlevel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    EducationLevel that = (EducationLevel) o;

    if (educationLevelID != that.educationLevelID) {
      return false;
    }
    return educationlevel.equals(that.educationlevel);
  }

  @Override
  public int hashCode() {
    int result = educationLevelID;
    result = 31 * result + educationlevel.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "EducationLevel{" +
        "educationlevel='" + educationlevel + '\'' +
        '}';
  }
}
