package br.com.arthurferreira;

public class PhysicalPerson extends Person{
  // Attribute
  private String cpf;

  public PhysicalPerson(String name, String address, String cpf) {
  // Super Attributes
    super(name, address);
    this.cpf = cpf;
  }

  // Getters and Setters
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    return  super.toString() + " Cpf: " + cpf;
  }
}

