package com.ladislav.model.member;

public class HousingQuestion {
  private final int housingQuestionID;
  private final String housingQuestion;


  public HousingQuestion(int housingQuestionID, String housingQuestion) {
    this.housingQuestionID = housingQuestionID;
    this.housingQuestion = housingQuestion;
  }

  public int getHousingQuestionID() {
    return housingQuestionID;
  }

  public String getHousingQuestion() {
    return housingQuestion;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    HousingQuestion that = (HousingQuestion) o;

    if (housingQuestionID != that.housingQuestionID) {
      return false;
    }
    return housingQuestion.equals(that.housingQuestion);
  }

  @Override
  public int hashCode() {
    int result = housingQuestionID;
    result = 31 * result + housingQuestion.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "HousingQuestion{" + "housingQuestion='" + housingQuestion + '\'' +
        '}';
  }
}
