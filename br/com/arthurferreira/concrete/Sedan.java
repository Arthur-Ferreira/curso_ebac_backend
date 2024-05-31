package br.com.arthurferreira.concrete;

import br.com.arthurferreira.abs.Car;

public class Sedan extends Car {
  public Sedan(String model, String color, int year) {
    super(model, color, year);
  }

  @Override
  public void drive() {
    System.out.println("Driving a sedan: " + getModel());
  }
}
