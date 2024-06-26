package src.br.com.arthurferreira.service;

import src.br.com.arthurferreira.dao.IContratoDao;


public class ContratoService implements IContratoService {

  private IContratoDao contratoDao;

  public ContratoService(IContratoDao dao) {
    this.contratoDao = dao;
  }

  @Override
  public String salvar() {
    contratoDao.salvar();
    return "Sucesso";
  }

  @Override
  public String buscar(int id) {
    return contratoDao.buscar(id);
  }

  @Override
  public void excluir(int id) {
    contratoDao.excluir(id);
  }

  @Override
  public void atualizar(int id, String novoContrato) {
    contratoDao.atualizar(id, novoContrato);
  }
}
