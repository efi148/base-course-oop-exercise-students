package Missions;

import Entities.Coordinates;

public class IntelligenceMission extends Mission {

  private String region;

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public IntelligenceMission(String region, Coordinates coordinates) {
    super(coordinates);
    this.region = region;
  }
}
