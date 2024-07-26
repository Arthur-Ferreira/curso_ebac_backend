/**
 * 
 */
package src.test.java.br.com.arthurferreira.dao;

import src.main.java.br.com.arthurferreira.dao.IProdutoDAO;
import src.main.java.br.com.arthurferreira.domain.Produto;
import src.main.java.br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

/**
 * @author arthur.ferreira
 *
 */
public class ProdutoDaoMock implements IProdutoDAO {

	@Override
	public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void excluir(String valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto consultar(String valor) {
		Produto produto = new Produto();
		produto.setCodigo(valor);
		return produto;
	}

	@Override
	public Collection<Produto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
