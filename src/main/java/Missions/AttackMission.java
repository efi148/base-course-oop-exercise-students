package Missions;

import Entities.Coordinates;

public class AttackMission extends Mission {
  private String target;

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public AttackMission(String target, Coordinates coordinates) {
    super(coordinates);
    this.target = target;
  }
}
