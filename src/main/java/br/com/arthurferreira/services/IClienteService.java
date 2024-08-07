/**
 * 
 */
package main.java.br.com.arthurferreira.services;

import br.com.arthurferreira.domain.Cliente;
import br.com.arthurferreira.exceptions.DAOException;
import br.com.arthurferreira.services.generic.IGenericService;

/**
 * @author arthur.ferreira
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
