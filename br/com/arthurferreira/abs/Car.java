package br.com.arthurferreira.abs;

public abstract class Car {
  private String model;
  private String color;
  private int year;

  public Car(String model, String color, int year) {
    this.model = model;
    this.color = color;
    this.year = year;
  }

  public String getModel() {
    return model;
  }

  public String getColor() {
    return color;
  }

  public int getYear() {
    return year;
  }

  public abstract void drive();

  @Override
  public String toString() {
    return year + " " + model + " (" + color + ")";
  }
}
