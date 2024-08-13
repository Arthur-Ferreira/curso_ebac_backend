package br.com.arthurferreira.service;

import java.util.List;

import br.com.arthurferreira.domain.Cliente;
import br.com.arthurferreira.exceptions.DAOException;
import br.com.arthurferreira.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
