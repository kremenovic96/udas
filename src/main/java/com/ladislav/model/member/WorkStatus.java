package com.ladislav.model.member;

public class WorkStatus {

  private final int workStatusID;
  private final String workStatus;

  public WorkStatus(int workStatusID, String workStatus) {
    this.workStatusID = workStatusID;
    this.workStatus = workStatus;
  }

  public int getWorkStatusID() {
    return workStatusID;
  }

  public String getWorkStatus() {
    return workStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    WorkStatus that = (WorkStatus) o;

    return workStatusID == that.workStatusID && workStatus.equals(that.workStatus);
  }

  @Override
  public int hashCode() {
    int result = workStatusID;
    result = 31 * result + workStatus.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "WorkStatus{" +
        "workStatusID=" + workStatusID +
        ", workStatus='" + workStatus + '\'' +
        '}';
  }
}
