package main.java.br.com.arthurferreira.domain;


/*
* @author: Arthur Ferreira
*/

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String codigo;
  private String nome;
  private String descricao;
  private BigDecimal preco;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private Categoria categoria;

  @ManyToMany(mappedBy = "produtos")
  private Set<Pedido> pedidos = new HashSet<>();


  public Long getId() {
    return id;
  }

  public void setId (Long id) {
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

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Set<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(Set<Pedido> pedidos) {
    this.pedidos = pedidos;
  }
}
