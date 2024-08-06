package main.java.br.com.arthurferreira.dao;

import main.java.br.com.arthurferreira.domain.Produto;

public interface IProdutoDao {

  public Produto cadastrar (Produto produto);

  public void excluir (Produto produto);
}
