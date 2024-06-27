package br.com.arthurferreira.services;

import br.com.arthurferreira.dao.IClienteDAO;
import br.com.arthurferreira.domain.Cliente;
import br.com.arthurferreira.services.generic.GenericService;

/**
 * @author arthur.ferreira
 */

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

  public ClienteService(IClienteDAO clienteDAO) {
    super(clienteDAO);
  }

  @Override
  public Cliente buscarPorCPF(Long cpf) {
    return this.dao.consultar(cpf);
  }
}
