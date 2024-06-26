package test.br.com.arthurferreira;

import src.br.com.arthurferreira.Cliente;
import src.br.com.arthurferreira.dao.ClienteDao;
import src.br.com.arthurferreira.dao.mocks.ClienteDaoMock;
import src.br.com.arthurferreira.dao.IClienteDao;
import src.br.com.arthurferreira.service.ClienteService;

import org.junit.Assert;
import org.junit.Test;


public class ClienteServiceTest {

  @Test
  public void salvarTest() {
    IClienteDao mockDao = new ClienteDaoMock();
    ClienteService service = new ClienteService(mockDao);
    Cliente cliente = new Cliente(1, "Arthur", "arthur@cliente.com", "123456789");
    String retorno = service.salvar(cliente);
    Assert.assertEquals("Sucesso", retorno);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void esperadoErroNoSalvarTest() {
    IClienteDao mockDao = new ClienteDao();
    ClienteService service = new ClienteService(mockDao);
    Cliente cliente = new Cliente(1, "Arthur", "arthur@cliente.com", "123456789");
    service.salvar(cliente);
  }

  @Test
  public void buscarTest() {
    IClienteDao mockDao = new ClienteDaoMock();
    ClienteService service = new ClienteService(mockDao);
    Cliente cliente = service.buscar(1);
    Assert.assertEquals("MockCliente", cliente.getNome());
  }

  @Test
  public void excluirTest() {
    IClienteDao mockDao = new ClienteDaoMock();
    ClienteService service = new ClienteService(mockDao);
    service.excluir(1);
    // Pode-se adicionar verificação dependendo da implementação
  }

  @Test
  public void atualizarTest() {
    IClienteDao mockDao = new ClienteDaoMock();
    ClienteService service = new ClienteService(mockDao);
    Cliente cliente = new Cliente(1, "NovoNome", "novo@cliente.com", "987654321");
    service.atualizar(1, cliente);
    // Pode-se adicionar verificação dependendo da implementação
  }
}