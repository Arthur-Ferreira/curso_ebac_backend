package src.br.com.arthurferreira.dao;


import src.br.com.arthurferreira.Cliente;

public interface IClienteDao {
  String salvar(Cliente cliente);

  Cliente buscar(int id);

  void excluir(int id);

  void atualizar(int id, Cliente cliente);

}