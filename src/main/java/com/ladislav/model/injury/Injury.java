package com.ladislav.model.injury;

public class Injury {

  private InjuryCause cause;
  private InjuryPosition position;
  private boolean amputation;

  public Injury(InjuryCause cause, InjuryPosition position, boolean amputation) {
    this.cause = cause;
    this.position = position;
    this.amputation = amputation;
  }

  public InjuryCause getCause() {
    return cause;
  }

  public InjuryPosition getPosition() {
    return position;
  }

  public boolean isAmputation() {
    return amputation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Injury injury = (Injury) o;

    if (amputation != injury.amputation) {
      return false;
    }
    if (!cause.equals(injury.cause)) {
      return false;
    }
    return position.equals(injury.position);
  }

  @Override
  public int hashCode() {
    int result = cause.hashCode();
    result = 31 * result + position.hashCode();
    result = 31 * result + (amputation ? 1 : 0);
    return result;
  }
}

