package com.elevadores.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

import static com.elevadores.demo.Elevator.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);

		System.out.println("Buscando elevadores disponibles, por favor ingrese un destino :");

		List<Elevator> elevatorList = new ArrayList<>();
		Elevator elevatorA = new Elevator(true, ELEVATOR_A, 0);
		Elevator elevatorB = new Elevator(true, ELEVATOR_B, 0);
		Elevator elevatorC = new Elevator(true, ELEVATOR_C, 0);

		elevatorList.add(elevatorA);
		elevatorList.add(elevatorB);
		elevatorList.add(elevatorC);

		elevatorCallOrchestrator proceso1 = new elevatorCallOrchestrator(elevatorList);
		elevatorCallOrchestrator proceso2 = new elevatorCallOrchestrator(elevatorList);
		elevatorCallOrchestrator proceso3 = new elevatorCallOrchestrator(elevatorList);

		proceso1.start();
		try {
			elevatorCallOrchestrator.sleep(3000);
		}catch (InterruptedException interruptedException){
			System.out.println("Error en el proceso 1: " + interruptedException);
		}
		proceso2.start();
		proceso3.start();
	}
}
