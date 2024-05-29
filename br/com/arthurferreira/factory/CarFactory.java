package br.com.arthurferreira.factory;

import br.com.arthurferreira.abs.Car;

public abstract class CarFactory {
  public abstract Car createElectricCar();
  public abstract Car createCombustionCar();
}