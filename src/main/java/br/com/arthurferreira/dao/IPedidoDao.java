package main.java.br.com.arthurferreira.dao;

import main.java.br.com.arthurferreira.domain.Pedido;

public interface IPedidoDao {

  public Pedido cadastrar(Pedido pedido);
  public void excluir(Pedido pedido);
}
