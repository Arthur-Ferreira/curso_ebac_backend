package src.br.com.arthurferreira;


public class Cliente {
  private int id;
  private String nome;
  private String email;
  private String telefone;

  public Cliente(int id, String nome, String email, String telefone) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
  }

  // Getters e Setters

  @Override
  public String toString() {
    return "Cliente{id=" + id + ", nome='" + nome + "', email='" + email + "', telefone='" + telefone + "'}";
  }

  public String getNome() {
    return nome;
  }
}