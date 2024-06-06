package br.com.arthurferreira;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
    // Lista de pessoas como uma string
    String pessoasStr = "Ana,F;João,M;Maria,F;Carlos,M;Patrícia,F;Bernardo,M;Caren,F;Arthur,M";

    // Converter a string em uma lista de objetos Pessoa
    List<Pessoa> pessoas = new ArrayList<>();
    for (String pessoaStr : pessoasStr.split(";")) {
      String[] atributos = pessoaStr.split(",");
      pessoas.add(new Pessoa(atributos[0], atributos[1]));
    }

    // Usar streams e expressões lambda para filtrar as mulheres
    List<Pessoa> mulheres = pessoas.stream()
        .filter(pessoa -> {
          return "F".equals(pessoa.getSexo());
        })
        .toList();

    // Imprimir a lista de mulheres
    mulheres.forEach(System.out::println);
  }
}
