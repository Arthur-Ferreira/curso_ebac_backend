package src.br.com.arthurferreira.dao.mocks;

import src.br.com.arthurferreira.dao.IContratoDao;

public class ContratoDaoMock implements IContratoDao {

    @Override
    public void salvar() {}

    @Override
    public String buscar(int id) {
        return "MockContrato";
    }

    @Override
    public void excluir(int id) {}

    @Override
    public String atualizar(int id, String novoContrato) {
        return novoContrato;
    }
}
