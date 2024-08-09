/**
 * 
 */
package test.java.br.com.arthurferreira;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.arthurferreira.dao.IProdutoDAO;
import test.java.br.com.arthurferreira.dao.ProdutoDaoMock;
import main.java.br.com.arthurferreira.domain.Produto;
import main.java.br.com.arthurferreira.exceptions.DAOException;
import main.java.br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;
import main.java.br.com.arthurferreira.services.IProdutoService;
import main.java.br.com.arthurferreira.services.ProdutoService;

/**
 * @author arthur.ferreira
 *
 */
public class ProdutoServiceTest {

	private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Arthur Ferreira");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Arthur Ferreira", produto.getNome());
	}
}
