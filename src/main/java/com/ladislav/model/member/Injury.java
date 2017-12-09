package com.ladislav.model.member;

public class Injury {

  InjuryType type;
  boolean amputated;

  public InjuryType getType() {
    return type;
  }

  public void setType(InjuryType type) {
    this.type = type;
  }

  public boolean isAmputated() {
    return amputated;
  }

  public void setAmputated(boolean amputated) {
    this.amputated = amputated;
  }
}
