/**
 * 
 */
package src.test.java.br.com.arthurferreira;


import src.main.java.br.com.arthurferreira.dao.IProdutoDAO;
import src.main.java.br.com.arthurferreira.domain.Produto;
import src.main.java.br.com.arthurferreira.exceptions.DAOException;
import src.main.java.br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;
import src.main.java.br.com.arthurferreira.services.IProdutoService;
import src.main.java.br.com.arthurferreira.services.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.test.java.br.com.arthurferreira.dao.ProdutoDaoMock;

import java.math.BigDecimal;

/**
 * @author arthur.ferreira
 *
 */
public class ProdutoServiceTest {

	private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = (IProdutoDAO) new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produto.setPeso(1d);
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
