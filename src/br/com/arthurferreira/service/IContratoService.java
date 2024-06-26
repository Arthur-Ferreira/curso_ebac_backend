package src.br.com.arthurferreira.service;


public interface IContratoService {
  String salvar();

  //TODO
  //Fazer métodos de buscar, excluir e atualizar

  String buscar(int id);

  void excluir(int id);

  void atualizar(int id, String novoContrato);
}
