package main.java.br.com.arthurferreira.dao;

import main.java.br.com.arthurferreira.domain.Categoria;

public interface ICategoriaDao {

  public Categoria cadastrar(Categoria categoria);

  public void excluir(Categoria categoria);
}
