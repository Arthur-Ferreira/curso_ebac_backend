package br.com.arthurferreira.factory;


import br.com.arthurferreira.abs.Car;
import br.com.arthurferreira.concret.ToyotaCombustionCar;
import br.com.arthurferreira.concret.ToyotaElectricCar;

public class ToyotaFactory extends CarFactory {
  @Override
  public Car createElectricCar() {
    return new ToyotaElectricCar();
  }

  @Override
  public Car createCombustionCar() {
    return new ToyotaCombustionCar();
  }
}