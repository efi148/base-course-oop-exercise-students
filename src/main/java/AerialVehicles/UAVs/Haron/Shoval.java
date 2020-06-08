package AerialVehicles.UAVs.Haron;

import AerialVehicles.AerialAttackVehicleService;
import AerialVehicles.AerialBdaVehicleService;
import AerialVehicles.AerialIntelligenceVehicleService;
import AerialVehicles.AerialVehicle;
import Missions.AttackMission;
import Missions.BdaMission;
import Missions.IntelligenceMission;
import Missions.Mission;

public class Shoval extends AerialVehicle
    implements AerialAttackVehicleService,
        AerialIntelligenceVehicleService,
        AerialBdaVehicleService {

  private int numMissile;
  private String missileType;
  private String sensorType;
  private String cameraType;

  static final int MAX_HOUERS = 150;

  public Shoval(
      String cameraType,
      int numMissile,
      String missileType,
      String sensorType,
      String pilotName,
      Mission missionType,
      int numbHoursElapsed,
      boolean readyToFly) {
    super(pilotName, missionType, numbHoursElapsed, readyToFly);
    this.numMissile = numMissile;
    this.missileType = missileType;
    this.sensorType = sensorType;
    this.cameraType = cameraType;
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
  public String preformBda() {
    return (this.getPilotName()
        + ": "
        + this.getClass().getSimpleName()
        + " taking pictures of "
        + ((BdaMission) getMission()).getObjective()
        + " with: "
        + this.cameraType
        + " camera");
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
