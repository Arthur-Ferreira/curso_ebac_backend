package src.br.com.arthurferreira.service;

import src.br.com.arthurferreira.Cliente;
import src.br.com.arthurferreira.dao.IClienteDao;


public class ClienteService {

  private IClienteDao clienteDao;

  public ClienteService(IClienteDao clienteDao) {
    this.clienteDao = clienteDao;
  }

  public String salvar(Cliente cliente) {
    return clienteDao.salvar(cliente);
  }

  public Cliente buscar(int id) {
    return clienteDao.buscar(id);
  }

  public void excluir(int id) {
    clienteDao.excluir(id);
  }

  public void atualizar(int id, Cliente cliente) {
    clienteDao.atualizar(id, cliente);
  }
}
