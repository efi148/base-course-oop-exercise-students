package AerialVehicles.UAVs.Hermes;

import AerialVehicles.AerialBdaVehicleService;
import AerialVehicles.AerialIntelligenceVehicleService;
import AerialVehicles.AerialVehicle;
import Missions.BdaMission;
import Missions.IntelligenceMission;
import Missions.Mission;

public class Zik extends AerialVehicle
    implements AerialIntelligenceVehicleService, AerialBdaVehicleService {
  private String sensorType;
  private String cameraType;

  static final int MAX_HOUERS = 100;

  public Zik(
      String cameraType,
      String sensorType,
      String pilotName,
      Mission missionType,
      int numbHoursElapsed,
      boolean readyToFly) {
    super(pilotName, missionType, numbHoursElapsed, readyToFly);
    this.sensorType = sensorType;
    this.cameraType = cameraType;
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
