package br.com.arthurferreira;

public class Main {
  public static void main(String[] args) {
    PhysicalPerson cpf = new PhysicalPerson("João Silva", "Rua A, 123", "123.456.789-00");
    JuridicalPerson cnpj = new JuridicalPerson("Empresa XYZ", "Avenida B, 456", "12.345.678/0001-99");

    System.out.println(cpf);
    System.out.println(cnpj);
  }
}