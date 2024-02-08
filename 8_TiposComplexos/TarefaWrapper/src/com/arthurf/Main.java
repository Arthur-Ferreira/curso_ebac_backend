package com.arthurf;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Criando um Scanner para leitura do valor
    Scanner scn = new Scanner(System.in);

    // Solicitação de valor
    System.out.print("Digite um valor numérico: ");
    int inteiroPrimitivo = scn.nextInt();

    // Casting para wrapper
    Integer inteiroWrapper = (Integer) inteiroPrimitivo;
    System.out.println("O valor digitado convertido é: " + inteiroWrapper);

    scn.close();
  }
}