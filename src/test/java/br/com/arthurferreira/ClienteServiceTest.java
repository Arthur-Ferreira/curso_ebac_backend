package br.com.arthurferreira;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.arthurferreira.dao.ClienteDaoMock;
import br.com.arthurferreira.dao.IClienteDAO;
import br.com.arthurferreira.domain.Cliente;
import br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;
import br.com.arthurferreira.services.ClienteService;
import br.com.arthurferreira.services.IClienteService;

/**
 * @author arthur.ferreira
 */

public class ClienteServiceTest {

  private IClienteService clienteService;

  private Cliente cliente;

  public ClienteServiceTest() {
    IClienteDAO dao = new ClienteDaoMock();
    clienteService = new ClienteService(dao);
  }

  @Before
  public void init() {
    cliente = new Cliente();
    cliente.setCpf(12312312312L);
    cliente.setNome("Arthur");
    cliente.setCidade("Porto Alegre");
    cliente.setEnd("End");
    cliente.setEstado("RS");
    cliente.setNumero(10);
    cliente.setTel(1199999999L);

  }

  @Test
  public void pesquisarCliente() {
    Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
    Assert.assertNotNull(clienteConsultado);
  }

  @Test
  public void salvarCliente() throws TipoChaveNaoEncontradaException {
    Boolean retorno = clienteService.cadastrar(cliente);

    Assert.assertTrue(retorno);
  }

  @Test
  public void excluirCliente() {
    clienteService.excluir(cliente.getCpf());
  }

  @Test
  public void alterarCliente() throws TipoChaveNaoEncontradaException {
    cliente.setNome("Arthur Ferreira");
    clienteService.alterar(cliente);

    Assert.assertEquals("Arthur Ferreira", cliente.getNome());
  }
}
