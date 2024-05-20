package br.com.arthurferreira;

import java.util.Arrays;
import java.util.Scanner;

public class OrderName {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Solicitando a entrada de nomes separado por vírgula
    System.out.print("Digite os nomes separados por vírgula: ");
    String dados = scan.nextLine();

    // Separando a string inicial em um array com o split
    String[] nomes = dados.split(",");

    // Remove espaços em branco ao redor de cada nome
    for (int i = 0; i < nomes.length; i++) {
      nomes[i] = nomes[i].trim();
    }

    // Ordenando o array em ordem alfabética
    Arrays.sort(nomes);

    // Impressão de nomes já ordenados
    for (int i = 0; i < nomes.length; i++) {
      System.out.println(nomes[i]);
    }
  }
}
