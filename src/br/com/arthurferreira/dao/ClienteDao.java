package src.br.com.arthurferreira.dao;

import src.br.com.arthurferreira.Cliente;

public class ClienteDao implements IClienteDao {

  @Override
  public String salvar(Cliente cliente) {
    throw new UnsupportedOperationException("Não funciona sem config de banco");
  }

  @Override
  public Cliente buscar(int id) {
    throw new UnsupportedOperationException("Não funciona sem config de banco");
  }

  @Override
  public void excluir(int id) {
    throw new UnsupportedOperationException("Não funciona sem config de banco");
  }

  @Override
  public void atualizar(int id, Cliente cliente) {
    throw new UnsupportedOperationException("Não funciona sem config de banco");
  }
}