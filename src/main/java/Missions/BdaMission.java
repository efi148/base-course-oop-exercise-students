package Missions;

import Entities.Coordinates;

public class BdaMission extends Mission {
  private String objective;

  public String getObjective() {
    return objective;
  }

  public void setObjective(String objective) {
    this.objective = objective;
  }

  public BdaMission(String objective, Coordinates coordinates) {
    super(coordinates);
    this.objective = objective;
  }
}
