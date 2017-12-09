package com.ladislav.model.member;

public class CityProvince {

  private final int cityProvinceID;
  private final  String cityProvince;
  private final int cityID;


  public CityProvince(int cityProvinceID, String cityProvince, int cityID) {
    this.cityProvinceID = cityProvinceID;
    this.cityProvince = cityProvince;
    this.cityID = cityID;
  }

  public int getCityProvinceID() {
    return cityProvinceID;
  }

  public String getCityProvince() {
    return cityProvince;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CityProvince that = (CityProvince) o;

    if (cityProvinceID != that.cityProvinceID) {
      return false;
    }
    if (cityID != that.cityID) {
      return false;
    }
    return cityProvince.equals(that.cityProvince);
  }

  @Override
  public int hashCode() {
    int result = cityProvinceID;
    result = 31 * result + cityProvince.hashCode();
    result = 31 * result + cityID;
    return result;
  }

  @Override
  public String toString() {
    return "CityProvince{" +
        "cityProvinceID=" + cityProvinceID +
        ", cityProvince='" + cityProvince + '\'' +
        ", cityID=" + cityID +
        '}';
  }
}
