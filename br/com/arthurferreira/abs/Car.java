package br.com.arthurferreira.abs;

public abstract class Car {

  private int horsePower;
  private String fuelSource;
  private String color;

  public Car (int horsePower, String fuelSource, String color) {
    this.horsePower = horsePower;
    this.fuelSource = fuelSource;
    this.color = color;
  }

  public void assemble() {
   System.out.println(getClass().getSimpleName());
   System.out.println("Assembling the vehicle");
  }

  public void clean(){
    System.out.println("Car has been cleaned, and the " + color.toLowerCase() + " color shines");
  }

  public void mechanicCheck() {
    System.out.println("Car has been checked by the mechanic. HorsePower: " + horsePower + ". Everything looks good!");
  }

  public void fuelCar(){
    System.out.println("Car is being filled with " + fuelSource.toLowerCase());
  }
}