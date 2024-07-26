/**
 * 
 */
package src.test.java.br.com.arthurferreira;

import src.test.java.br.com.arthurferreira.dao.ClienteDaoMock;
import src.main.java.br.com.arthurferreira.dao.IClienteDAO;
import src.main.java.br.com.arthurferreira.domain.Cliente;
import src.main.java.br.com.arthurferreira.exceptions.DAOException;
import src.main.java.br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;
import src.main.java.br.com.arthurferreira.services.ClienteService;
import src.main.java.br.com.arthurferreira.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author arthur.ferreira
 *
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
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Arthur Ferreira");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Arthur Ferreira", cliente.getNome());
	}
}
