package br.com.arthurferreira;

@Tabela("carros")
public class Carro {
  private String modelo;
  private int fabricacao;

  public Carro(String modelo, int fabricacao) {
    this.modelo = modelo;
    this.fabricacao = fabricacao;
  }

  // Getters e Setters
  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getFabricacao() {
    return fabricacao;
  }

  public void setFabricacao(int fabricacao) {
    this.fabricacao = fabricacao;
  }
}
