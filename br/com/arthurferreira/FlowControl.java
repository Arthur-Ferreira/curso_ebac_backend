package br.com.arthurferreira;

import java.util.Scanner;

public class FlowControl {

   public static void main(String[] args) {
     // Variables
     int grade1, grade2, grade3, grade4, result;
     Scanner keyboard = new Scanner(System.in);

     // Input
     System.out.println("Informe a primeira nota: ");
     grade1 = keyboard.nextInt();

     System.out.println("Informe a segunda nota: ");
     grade2 = keyboard.nextInt();

     System.out.println("Informe a terceira nota: ");
     grade3 = keyboard.nextInt();

     System.out.println("Informe a quarta nota: ");
     grade4 = keyboard.nextInt();

     // Logic / Output

     result = (grade1 + grade2 + grade3 + grade4) / 4;

     if (result >= 7){
       System.out.println("Aluno Aprovado!!! :D");
     } else if (result >= 5) {
       System.out.println("Aluno em Recuperação!! :/");
     } else {
       System.out.println("Aluno Reprovado! :(");
     }
   }
}
