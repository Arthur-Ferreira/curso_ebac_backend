package main.java.br.com.arthurferreira.dao;

import main.java.br.com.arthurferreira.domain.Produto;

import java.util.List;

/**
 * @author arthur.ferreira
 */

public interface IProdutoDao {

	public Produto cadastrar(Produto produto);

	public void excluir(Produto produto);

	public List<Produto> buscarTodos();
}
