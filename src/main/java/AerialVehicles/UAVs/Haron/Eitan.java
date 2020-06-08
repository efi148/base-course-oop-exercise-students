package AerialVehicles.UAVs.Haron;

import AerialVehicles.AerialAttackVehicleService;
import AerialVehicles.AerialIntelligenceVehicleService;
import AerialVehicles.AerialVehicle;
import Missions.AttackMission;
import Missions.IntelligenceMission;
import Missions.Mission;

public class Eitan extends AerialVehicle
    implements AerialAttackVehicleService, AerialIntelligenceVehicleService {

  private int numMissile;
  private String missileType;
  private String sensorType;

  static final int MAX_HOUERS = 150;

  public Eitan(
      int numMissile,
      String missileType,
      String sensorType,
      String pilotName,
      Mission missionType,
      int getHoursOfFlightSinceLastRepair,
      boolean readyToFly) {
    super(pilotName, missionType, getHoursOfFlightSinceLastRepair, readyToFly);
    this.numMissile = numMissile;
    this.missileType = missileType;
    this.sensorType = sensorType;
  }

  @Override
  public String attack() {
    return (this.getPilotName()
        + ": "
        + this.getClass().getSimpleName()
        + " Attacking "
        + ((AttackMission) getMission()).getTarget()
        + " with: "
        + this.missileType
        + "X"
        + this.numMissile);
  }

  @Override
  public String collectIntelligence() {
    return (this.getPilotName()
        + ": "
        + this.getClass().getSimpleName()
        + " Collecting Data in "
        + ((IntelligenceMission) getMission()).getRegion()
        + " with sensor type: "
        + this.sensorType);
  }

  @Override
  public void check() {
    if (this.getHoursOfFlightSinceLastRepair() > MAX_HOUERS) repair();
  }
}
