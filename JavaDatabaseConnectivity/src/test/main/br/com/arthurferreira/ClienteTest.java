
package JavaDatabaseConnectivity.src.test.main.br.com.arthurferreira;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.cliente.ClienteDAO;
import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.cliente.IClienteDAO;
import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.domain.Cliente;

/**
 * @author arthur.ferreira
 */

public class ClienteTest {

	@Test
	public void cadastrarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Arthur Ferreira");

		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);

		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());

		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
	}

	@Test
	public void atualizarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		// Cadastro de um cliente para atualizar depois
		Cliente cliente = new Cliente();
		cliente.setCodigo("02");
		cliente.setNome("Arthur Ferreira");

		Integer qtdCadastro = dao.cadastrar(cliente);
		assertTrue(qtdCadastro == 1);

		// Atualiza o cliente
		cliente.setNome("Arthur F. Ferreira");

		Integer qtdAtualizacao = dao.atualizar(cliente);
		assertTrue(qtdAtualizacao == 1);

		// Verifica se a atualização foi feita
		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertEquals(cliente.getNome(), clienteBD.getNome());

		// Limpeza após o teste
		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
	}

	@Test
	public void conssultarTodosTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		// Cadastro de alguns Clientes
		Cliente cliente1 = new Cliente();
		cliente1.setCodigo("03");
		cliente1.setNome("Caren Cristina");
		dao.cadastrar(cliente1);

		Cliente cliente2 = new Cliente();
		cliente2.setCodigo("04");
		cliente2.setNome("Caren Cristina");
		dao.cadastrar(cliente2);

		// Consultar todos os Clientes
		List<Cliente> clientes = dao.consultarTodos();
		assertNotNull(clientes);
		assertTrue(clientes.size() > 1);

		int countDel = 0;
		for (Cliente cli : clientes) {
			dao.excluir(cli);
			countDel++;
		}
		assertEquals(clientes.size(), countDel);

		clientes = dao.consultarTodos();
		assertEquals(clientes.size(), 0);
	}
}
