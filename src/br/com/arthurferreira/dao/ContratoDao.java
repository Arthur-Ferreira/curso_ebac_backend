package src.br.com.arthurferreira.dao;


public class ContratoDao implements IContratoDao {

  @Override
  public void salvar() {
    throw new UnsupportedOperationException("Não funciona com o banco");
  }

  @Override
  public String buscar(int id) {
    throw new UnsupportedOperationException("Não funciona sem config de banco");
  }

  @Override
  public void excluir(int id) {
    throw new UnsupportedOperationException("Não funciona sem config de banco");
  }

  @Override
  public String atualizar(int id, String novoContrato) {
    throw new UnsupportedOperationException("Não funciona sem config de banco");
  }
}
