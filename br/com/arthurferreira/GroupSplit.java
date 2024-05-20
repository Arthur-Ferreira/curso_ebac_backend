package br.com.arthurferreira;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupSplit {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    List<String> maleGroup = new ArrayList<>();
    List<String> femaleGroup = new ArrayList<>();

    while (true) {
      System.out.print("Digite o nome e o sexo no formato 'Nome - Sexo' (ou digite 'sair' para terminar): ");
      String dados = scan.nextLine();

      if (dados.equalsIgnoreCase("sair")) {
        break;
      }

      // Divide a entrada no formato "Nome - Sexo"
      String[] partes = dados.split(" - ");
      if (partes.length != 2) {
        System.out.println("Formato inválido. Por favor, use o formato 'Nome - Sexo'.");
        continue;
      }

      String nome = partes[0].trim();
      String sexo = partes[1].trim().toUpperCase();

      if (sexo.equals("M")) {
        maleGroup.add(nome);
      } else if (sexo.equals("F")) {
        femaleGroup.add(nome);
      } else {
        System.out.println("Sexo inválido. Por favor, digite 'M' para masculino ou 'F' para feminino.");
      }
    }

    System.out.println("Grupo Masculino: " + maleGroup);
    System.out.println("Grupo Feminino: " + femaleGroup);

    scan.close();
  }
}
