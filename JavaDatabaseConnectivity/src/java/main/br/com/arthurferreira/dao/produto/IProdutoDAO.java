package JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.produto;

import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.domain.Produto;

import java.util.List;

/**
 * @author arthur.ferreira
 */

public interface IProdutoDAO {

	public Integer cadastrar(Produto produto) throws Exception;

	public Produto consultar(String codigo) throws Exception;

	public Integer excluir(Produto clienteBD) throws Exception;

	// TODO: Buscar Todos e o Atualizar

	public List<Produto> consultarTodos() throws Exception;

	public Integer atualizar(Produto produto) throws Exception;
}
