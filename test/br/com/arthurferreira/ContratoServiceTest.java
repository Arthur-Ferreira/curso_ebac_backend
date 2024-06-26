package test.br.com.arthurferreira;

import src.br.com.arthurferreira.dao.IContratoDao;
import src.br.com.arthurferreira.dao.mocks.ContratoDaoMock;
import src.br.com.arthurferreira.dao.ContratoDao;
import src.br.com.arthurferreira.service.ContratoService;
import src.br.com.arthurferreira.service.IContratoService;

import org.junit.Assert;
import org.junit.Test;


public class ContratoServiceTest {

  @Test
  public void salvarTest() {
    IContratoDao dao = new ContratoDaoMock();
    IContratoService service = new ContratoService(dao);
    String retorno = service.salvar();
    Assert.assertEquals("Sucesso", retorno);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void esperadoErroNoSalvarComBancoDeDadosTest() {
    IContratoDao dao = new ContratoDao();
    IContratoService service = new ContratoService(dao);
    String retorno = service.salvar();
    Assert.assertEquals("Sucesso", retorno);
  }

  //TODO
  //Fazer métodos de buscar, excluir e atualizar

  @Test
  public void buscarTest() {
    IContratoDao dao = new ContratoDaoMock();
    IContratoService service = new ContratoService(dao);
    String contrato = service.buscar(1);
    Assert.assertEquals("MockContrato", contrato);
  }

  @Test
  public void excluirTest() {
    IContratoDao dao = new ContratoDaoMock();
    IContratoService service = new ContratoService(dao);
    service.excluir(1);
    // Pode-se adicionar verificação dependendo da implementação
  }

  @Test
  public void atualizarTest() {
    IContratoDao dao = new ContratoDaoMock();
    IContratoService service = new ContratoService(dao);
    service.atualizar(1, "NovoContrato");
    // Pode-se adicionar verificação dependendo da implementação
  }
}
