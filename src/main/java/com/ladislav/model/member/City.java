package com.ladislav.model.member;

public class City {

  private final int cityID;
  private final String city;
  private final int postNumber;

  public City(int cityID, String city, int postNumber) {
    this.cityID = cityID;
    this.city = city;
    this.postNumber = postNumber;
  }

  public int getCityID() {
    return cityID;
  }

  public String getCity() {
    return city;
  }

  public int getPostNumber() {
    return postNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    City city1 = (City) o;

    return cityID == city1.cityID && postNumber == city1.postNumber && city.equals(city1.city);
  }

  @Override
  public int hashCode() {
    int result = cityID;
    result = 31 * result + city.hashCode();
    result = 31 * result + postNumber;
    return result;
  }

  @Override
  public String toString() {
    return "City{" +
        "city='" + city + '\'' +
        ", postNumber=" + postNumber +
        '}';
  }
}
