package br.com.arthurferreira;

public class Person {

  // Class attributes
  private String name;
  private String address;

  // Constructor
  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  // Getters and Setters
  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Nome: " + name + "Endereço: " + address;
  }
}
