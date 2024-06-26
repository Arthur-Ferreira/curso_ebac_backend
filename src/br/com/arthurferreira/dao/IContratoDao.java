package src.br.com.arthurferreira.dao;



public interface IContratoDao {
    void salvar();

    // TODO
    // Fazer métodos de buscar, excluir e atualizar

    String buscar(int id);

    void excluir(int id);

    String atualizar(int id, String novoContrato);
}
