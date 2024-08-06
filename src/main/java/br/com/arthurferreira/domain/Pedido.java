package main.java.br.com.arthurferreira.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime data;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
      name = "PEDIDO_PRODUTO",
      joinColumns = @JoinColumn(name = "pedido_id"),
      inverseJoinColumns = @JoinColumn(name = "produto_id")
  )
  private Set<Produto> produtos = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(Set<Produto> produtos) {
    this.produtos = produtos;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }

  public void addProduto(Produto produto) {
    this.produtos.add(produto);
    produto.getPedidos().add(this);
  }

}
