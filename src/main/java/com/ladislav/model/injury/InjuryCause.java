package com.ladislav.model.injury;

public class InjuryCause {

  private final int injuryCauseID;
  private final String injuryCause;


  public InjuryCause(int injuryCauseID, String injuryCause) {
    this.injuryCauseID = injuryCauseID;
    this.injuryCause = injuryCause;
  }

  public int getInjuryCauseID() {
    return injuryCauseID;
  }

  public String getInjuryCause() {
    return injuryCause;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    InjuryCause that = (InjuryCause) o;

    if (injuryCauseID != that.injuryCauseID) {
      return false;
    }
    return injuryCause.equals(that.injuryCause);
  }

  @Override
  public int hashCode() {
    int result = injuryCauseID;
    result = 31 * result + injuryCause.hashCode();
    return result;
  }
}
