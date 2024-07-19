package JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.domain;

/**
 * @author arthur.ferreira
 *
 */
public class Produto {

  private Long id;

  private String codigo;

  private String nome;

  private String descricao;

  private Float preco;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Float getPreco() {
    return preco;
  }

  public void setPreco(Float preco) {
    this.preco = preco;
  }
}
