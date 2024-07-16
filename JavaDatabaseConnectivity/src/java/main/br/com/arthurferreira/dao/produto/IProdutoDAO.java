package br.com.arthurferreira.dao;

import br.com.arthurferreira.domain.Produto;

/**
 * @author arthur.ferreira
 *
 */
public interface IProdutoDAO {

	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;

	// TODO: Buscar Todos e o Atualizar
	
}
