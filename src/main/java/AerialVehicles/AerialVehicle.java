package AerialVehicles;

import Missions.Mission;

public abstract class AerialVehicle implements AerialVehicleService {
  private String PilotName;
  private Mission mission;
  private int hoursOfFlightSinceLastRepair;
  private boolean readyToFly;

  public AerialVehicle(
      String pilotName, Mission mission, int hoursOfFlightSinceLastRepair, boolean readyToFly) {
    PilotName = pilotName;
    this.mission = mission;
    this.hoursOfFlightSinceLastRepair = hoursOfFlightSinceLastRepair;
    this.readyToFly = readyToFly;
  }

  @Override
  public void flyTo() {
    System.out.println(
        this.mission.getCoordinates().getLongitude()
            + " , "
            + this.mission.getCoordinates().getLatitude());
  }

  @Override
  public void land() {
    System.out.println("Landing");
  }

  @Override
  public void repair() {
    readyToFly = true;
    this.hoursOfFlightSinceLastRepair = 0;
  }

  public String getPilotName() {
    return PilotName;
  }

  public void setPilotName(String pilotName) {
    PilotName = pilotName;
  }

  public boolean isReadyToFly() {
    return readyToFly;
  }

  public void setReadyToFly(boolean readyToFly) {
    this.readyToFly = readyToFly;
  }

  public Mission getMission() {
    return mission;
  }

  public void setMission(Mission mission) {
    this.mission = mission;
  }

  public void setHoursOfFlightSinceLastRepair(int hoursOfFlightSinceLastRepair) {
    this.hoursOfFlightSinceLastRepair = hoursOfFlightSinceLastRepair;
  }

  public int getHoursOfFlightSinceLastRepair() {
    return hoursOfFlightSinceLastRepair;
  }
}
