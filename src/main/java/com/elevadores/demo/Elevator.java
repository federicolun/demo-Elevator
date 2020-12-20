package com.elevadores.demo;

public class Elevator {

    public static final String ELEVATOR_A = "Elevador A";
    public static final String ELEVATOR_B = "Elevador B";
    public static final String ELEVATOR_C = "Elevador C";

    private String elevatorID = "";
    private String elevatorMessage = "";

    private boolean available;
    private int floor;

    public Elevator (boolean availableStatus, String elevatorID, int floor) {
        this.available = availableStatus;
        this.elevatorID = elevatorID;
        this.floor = floor;
    }

    public void setElevatorID(String elevatorID) {
        this.elevatorID = elevatorID;
    }

    public String getElevatorID() {
        return elevatorID;
    }

    public String setElevatorMessage(String mensaje) {
       return this.elevatorMessage = mensaje;
    }

    public void setAvailable(boolean disponible) {
        this.available = disponible;
    }

    public int getFloor() {
        return floor;
    }

    public int setFloor(int floor) {
        return this.floor = floor;
    }

    public boolean isAvailable() {
        return available;
    }
}
