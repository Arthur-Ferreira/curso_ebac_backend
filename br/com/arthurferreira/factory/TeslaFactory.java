package br.com.arthurferreira.factory;

import br.com.arthurferreira.abs.Car;
import br.com.arthurferreira.concret.TeslaCombustionCar;
import br.com.arthurferreira.concret.TeslaElectricCar;

public class TeslaFactory extends CarFactory {
  @Override
  public Car createElectricCar() {
    return new TeslaElectricCar();
  }

  @Override
  public Car createCombustionCar() {
    return new TeslaCombustionCar();
  }
}