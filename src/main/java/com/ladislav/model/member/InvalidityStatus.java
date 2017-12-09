package com.ladislav.model.member;

public class InvalidityStatus {

  private final int invalidityStatusID;
  private final String invalidityStatus;

  public InvalidityStatus(int invalidityStatusID, String invalidityStatus) {
    this.invalidityStatusID = invalidityStatusID;
    this.invalidityStatus = invalidityStatus;
  }

  public int getInvalidityStatusID() {
    return invalidityStatusID;
  }

  public String getInvalidityStatus() {
    return invalidityStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    InvalidityStatus that = (InvalidityStatus) o;

    if (invalidityStatusID != that.invalidityStatusID) {
      return false;
    }
    return invalidityStatus.equals(that.invalidityStatus);
  }

  @Override
  public int hashCode() {
    int result = invalidityStatusID;
    result = 31 * result + invalidityStatus.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "InvalidityStatus{" +
        "invalidityStatus='" + invalidityStatus + '\'' +
        '}';
  }
}
