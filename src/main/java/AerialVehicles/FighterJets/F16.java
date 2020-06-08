package AerialVehicles.FighterJets;

import AerialVehicles.AerialAttackVehicleService;
import AerialVehicles.AerialBdaVehicleService;
import AerialVehicles.AerialVehicle;
import Missions.AttackMission;
import Missions.BdaMission;
import Missions.Mission;

public class F16 extends AerialVehicle
    implements AerialAttackVehicleService, AerialBdaVehicleService {

  private int numMissile;
  private String missileType;
  private String cameraType;

   static final int MAX_HOUERS = 250;

  public F16(
      String cameraType,
      int numMissile,
      String missileType,
      String pilotName,
      Mission missionType,
      int numbHoursElapsed,
      boolean readyToFly) {
    super(pilotName, missionType, numbHoursElapsed, readyToFly);
    this.numMissile = numMissile;
    this.missileType = missileType;
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
  public void check() {
    if (this.getHoursOfFlightSinceLastRepair() > MAX_HOUERS) repair();
  }
}
