package br.com.arthurferreira;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Collections {
  public static void main(String[] args) {
    // Scanner declaration
    Scanner scan = new Scanner(System.in);

    // Arrays declarations
    List<String> maleGroup = new ArrayList<>();
    List<String> femaleGroup = new ArrayList<>();

    // Logic

    while (true) {
      System.out.print("Digite o nome: ");
      String nome = scan.nextLine();

      System.out.print("Digite o sexo (M/F): ");
      String sexo = scan.nextLine().toUpperCase();

      if(sexo.equals("M")) {
        maleGroup.add(nome);
      } else if (sexo.equals("F")) {
        femaleGroup.add(nome);
      } else {
        System.out.println("Sexo inválido. Por favor, digite uma opção válida.");
      }

      System.out.print("Deseja continuar (S/N)? ");
      String continuar = scan.nextLine().toUpperCase();

      if (continuar.equals("N")) {
        break;
      }
    }

    System.out.println("Grupo Masculino: " + maleGroup);
    System.out.println("Grupo Feminino: " + femaleGroup);

    scan.close();
  }
}
