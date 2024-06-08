package br.com.arthurferreira.test;

import br.com.arthurferreira.Pessoa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

  @Test
  public void testListaContemSomenteMulheres() {
    // Lista de pessoas como uma string
    String pessoasStr = "Ana,F;João,M;Maria,F;Carlos,M;Patrícia,F";

    // Converter a string em uma lista de objetos Pessoa
    List<Pessoa> pessoas = new ArrayList<>();
    for (String pessoaStr : pessoasStr.split(";")) {
      String[] atributos = pessoaStr.split(",");
      pessoas.add(new Pessoa(atributos[0], atributos[1]));
    }

    // Usar streams e expressões lambda para filtrar as mulheres
    List<Pessoa> mulheres = pessoas.stream()
        .filter(pessoa -> {
          if ("F".equals(pessoa.getSexo())) {
            return true;
          } else {
            return false;
          }
        })
        .collect(Collectors.toList());

    // Verificar se a lista de mulheres contém somente pessoas do sexo feminino
    assertTrue(mulheres.stream().allMatch(pessoa -> "F".equals(pessoa.getSexo())));
  }
}
