package br.com.arthurferreira;

public class Pessoa {
  // Use "M" para masculino e "F" para feminino
  private final String nome;
  private final String sexo;

  public Pessoa(String nome, String sexo) {
    this.nome = nome;
    this.sexo = sexo;
  }

  public String getNome() {
    return nome;
  }

  public String getSexo() {
    return sexo;
  }

  @Override
  public String toString() {
    return "Pessoa{nome='" + nome + "', sexo='" + sexo + "'}";
  }
}