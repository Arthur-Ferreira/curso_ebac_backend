/**
 * 
 */
package br.com.arthurferreira.dao;

import br.com.arthurferreira.domain.Cliente;

/**
 * @author arthur.ferreira
 *
 */
public interface IClienteDAO {

	
	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;
}
