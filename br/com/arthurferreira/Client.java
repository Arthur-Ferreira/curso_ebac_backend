package br.com.arthurferreira;

import br.com.arthurferreira.abs.Car;
import br.com.arthurferreira.factory.CarFactory;
import br.com.arthurferreira.factory.TeslaFactory;
import br.com.arthurferreira.factory.ToyotaFactory;

public class Client {
  private final Car electricCar;
  private final Car combustionCar;

  public Client(CarFactory factory) {
    electricCar = factory.createElectricCar();
    combustionCar = factory.createCombustionCar();
  }

  public void operateCars() {
    System.out.println("\nOperating Electric Car:");
    electricCar.assemble();
    electricCar.clean();
    electricCar.mechanicCheck();
    electricCar.fuelCar();

    System.out.println("\nOperating Combustion Car:");
    combustionCar.assemble();
    combustionCar.clean();
    combustionCar.mechanicCheck();
    combustionCar.fuelCar();
  }

  public static void main(String[] args) {
    CarFactory teslaFactory = new TeslaFactory();
    Client teslaClient = new Client(teslaFactory);
    System.out.println("Tesla Factory:");
    teslaClient.operateCars();

    CarFactory toyotaFactory = new ToyotaFactory();
    Client toyotaClient = new Client(toyotaFactory);
    System.out.println("\nToyota Factory:");
    toyotaClient.operateCars();
  }
}