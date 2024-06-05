package br.com.arthurferreira;

import java.lang.annotation.Annotation;

public class App {
    public static void main(String[] args) {
      // Obter a classe anotada
      Class<Carro> carroClass = Carro.class;

      // Verificar se a anotação @Tabela está presente
      if (carroClass.isAnnotationPresent(Tabela.class)) {
        // Obter a anotação
        Tabela tabela = carroClass.getAnnotation(Tabela.class);
        // Imprimir o valor da anotação (nome da tabela)
        System.out.println("Nome da Tabela: " + tabela.value());
      } else {
        System.out.println("A classe Pessoa não possui a anotação @Tabela.");
      }
    }
}
