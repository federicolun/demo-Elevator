package com.elevadores.demo;

import java.util.List;
import java.util.Scanner;

public class elevatorCallOrchestrator extends Thread{

    List<Elevator> elevatorList;

    @Override
    public void run(){
        if (this.elevatorCall() == null){
            System.out.println("No hay elevadores disponibles");
        }
    }

    public elevatorCallOrchestrator(List<Elevator> elevatorList){
        super();
        this.elevatorList = elevatorList;
    }

    public Elevator elevatorCall(){

        Scanner reader = new Scanner(System.in);
        int requestElevator = reader.nextInt();
        System.out.println("Llamando elevador desde el piso: " + requestElevator + "\n");

        Elevator elevatorA = elevatorList.get(0);
        Elevator elevatorB = elevatorList.get(1);
        Elevator elevatorC = elevatorList.get(2);

        if (requestElevator != -1 && requestElevator <= 20) {

            for (Elevator availableElevator : elevatorList) {
                if (availableElevator.getFloor() == requestElevator){
                    System.out.println("Abriendo puerta en el piso : " + requestElevator + " del elevador " + availableElevator.getElevatorID());
                    return availableElevator;
                }
            }
            System.out.println(elevatorA.isAvailable() ? elevatorA.setElevatorMessage("Elevador A disponible") : elevatorA.setElevatorMessage("Elevador A no disponible"));
            System.out.println(elevatorB.isAvailable() ? elevatorB.setElevatorMessage("Elevador B disponible") : elevatorB.setElevatorMessage("Elevador B no disponible"));
            System.out.println(elevatorC.isAvailable() ? elevatorC.setElevatorMessage("Elevador C disponible"+ "\n") : elevatorC.setElevatorMessage("Elevador C no disponible" + "\n"));

            for (Elevator availableElevator : elevatorList) {
                if (availableElevator.isAvailable()){

                    availableElevator.setAvailable(false);

                    System.out.println(availableElevator.setElevatorMessage(availableElevator.getElevatorID()+ " disponible, comenzando el viaje al piso " + requestElevator + "\n"));
                    availableElevator.setFloor(requestElevator);

                    System.out.println("Subiendo..");
                    for (int i = 0; i<= requestElevator; i++) {
                        System.out.println(i);
                        try {
                            elevatorCallOrchestrator.sleep(1000);
                        }catch (InterruptedException interruptedException){
                            System.out.println("Ocurrió un error durante el viaje: " + interruptedException);
                        }
                    }
                    System.out.println(availableElevator.getElevatorID() + " llegó al piso: " + requestElevator);
                    availableElevator.setAvailable(true);
                    return availableElevator;
                }
            }
        }
        return null;
    }

}
