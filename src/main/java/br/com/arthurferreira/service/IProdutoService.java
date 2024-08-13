package br.com.arthurferreira.service;

import java.util.List;

import br.com.arthurferreira.domain.Produto;
import br.com.arthurferreira.services.generic.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
