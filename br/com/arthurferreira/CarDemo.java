package br.com.arthurferreira;

import br.com.arthurferreira.abs.Car;
import br.com.arthurferreira.concrete.SUV;
import br.com.arthurferreira.concrete.Sedan;
import br.com.arthurferreira.concrete.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarDemo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Car> cars = new ArrayList<>();

    while (true) {
      System.out.println("Enter the type of car (Sedan, SUV, Truck) or 'exit' to finish:");
      String type = scanner.nextLine();

      if (type.equalsIgnoreCase("exit")) {
        break;
      }

      System.out.println("Enter the model:");
      String model = scanner.nextLine();

      System.out.println("Enter the color:");
      String color = scanner.nextLine();

      System.out.println("Enter the year:");
      int year = scanner.nextInt();
      scanner.nextLine();  // Consume the newline

      Car car;
      switch (type.toLowerCase()) {
        case "sedan":
          car = new Sedan(model, color, year);
          break;
        case "suv":
          car = new SUV(model, color, year);
          break;
        case "truck":
          car = new Truck(model, color, year);
          break;
        default:
          System.out.println("Invalid car type. Please enter 'Sedan', 'SUV', or 'Truck'.");
          continue;
      }

      cars.add(car);
    }

    System.out.println("\nList of cars:");
    for (Car car : cars) {
      System.out.println(car);
      car.drive();
    }

    scanner.close();
  }
}