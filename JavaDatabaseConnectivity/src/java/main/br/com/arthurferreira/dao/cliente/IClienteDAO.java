package JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.cliente;

import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.domain.Cliente;

import java.util.List;

/**
 * @author arthur.ferreira
 */

public interface IClienteDAO {

	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;

// TODO: Atualizar
	public Integer atualizar(Cliente cliente) throws Exception;

// TODO: Consultar Todos
	public List<Cliente> consultarTodos() throws Exception;
}
