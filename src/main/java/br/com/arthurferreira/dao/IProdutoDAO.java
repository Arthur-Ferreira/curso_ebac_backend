package br.com.arthurferreira.dao;

import java.util.List;

import br.com.arthurferreira.dao.generic.IGenericDAO;
import br.com.arthurferreira.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}
