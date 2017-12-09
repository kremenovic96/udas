package com.ladislav.model.injury;

public class InjuryPosition {
  private final int injuryPositionID;
  private final String injuryPosition;

  public InjuryPosition(int injuryPositionID, String injuryPosition) {
    this.injuryPositionID = injuryPositionID;
    this.injuryPosition = injuryPosition;
  }

  public int getInjuryPositionID() {
    return injuryPositionID;
  }

  public String getInjuryPosition() {
    return injuryPosition;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    InjuryPosition that = (InjuryPosition) o;

    if (injuryPositionID != that.injuryPositionID) {
      return false;
    }
    return injuryPosition.equals(that.injuryPosition);
  }

  @Override
  public int hashCode() {
    int result = injuryPositionID;
    result = 31 * result + injuryPosition.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "InjuryPosition{" +
        "injuryPosition='" + injuryPosition + '\'' +
        '}';
  }
}
