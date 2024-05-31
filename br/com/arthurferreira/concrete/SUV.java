package br.com.arthurferreira.concrete;

import br.com.arthurferreira.abs.Car;

public class SUV extends Car {
  public SUV(String model, String color, int year) {
    super(model, color, year);
  }

  @Override
  public void drive() {
    System.out.println("Driving an SUV: " + getModel());
  }
}