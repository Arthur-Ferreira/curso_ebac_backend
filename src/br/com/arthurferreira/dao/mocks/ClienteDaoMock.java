package src.br.com.arthurferreira.dao.mocks;

import src.br.com.arthurferreira.Cliente;
import src.br.com.arthurferreira.dao.IClienteDao;

public class ClienteDaoMock implements IClienteDao {

  @Override
  public String salvar(Cliente cliente) {
    return "Sucesso";
  }

  @Override
  public Cliente buscar(int id) {
    return new Cliente(id, "MockCliente", "mock@cliente.com", "123456789");
  }

  @Override
  public void excluir(int id) {
  }

  @Override
  public void atualizar(int id, Cliente cliente) {

  }

}
