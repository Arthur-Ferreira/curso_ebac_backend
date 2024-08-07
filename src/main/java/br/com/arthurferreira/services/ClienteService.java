/**
 * 
 */
package main.java.br.com.arthurferreira.services;

import br.com.arthurferreira.dao.IClienteDAO;
import br.com.arthurferreira.domain.Cliente;
import br.com.arthurferreira.exceptions.DAOException;
import br.com.arthurferreira.exceptions.MaisDeUmRegistroException;
import br.com.arthurferreira.exceptions.TableException;
import br.com.arthurferreira.services.generic.GenericService;

/**
 * @author arthur.ferreira
 *
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	//private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		//this.clienteDAO = clienteDAO;
	}

//	@Override
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}

}
