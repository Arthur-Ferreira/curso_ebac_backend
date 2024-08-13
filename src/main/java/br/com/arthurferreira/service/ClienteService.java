package br.com.arthurferreira.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.arthurferreira.dao.IClienteDAO;
import br.com.arthurferreira.domain.Cliente;
import br.com.arthurferreira.exceptions.DAOException;
import br.com.arthurferreira.exceptions.MaisDeUmRegistroException;
import br.com.arthurferreira.exceptions.TableException;
import br.com.arthurferreira.services.generic.GenericService;

@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	private IClienteDAO clienteDAO;
	
	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

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

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

}
