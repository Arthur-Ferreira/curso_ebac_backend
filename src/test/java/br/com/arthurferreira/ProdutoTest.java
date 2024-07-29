package test.java.br.com.arthurferreira;

import static org.junit.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

import main.java.br.com.arthurferreira.dao.ProdutoDao;
import main.java.br.com.arthurferreira.dao.IProdutoDao;
import org.testng.annotations.Test;

import main.java.br.com.arthurferreira.domain.Produto;


import java.math.BigDecimal;
import java.util.List;

/**
 * @author arthur.ferreira
 */

public class ProdutoTest {

	private IProdutoDao produtoDao;
	
	public ProdutoTest() {
		produtoDao = new ProdutoDao();
	}

	@Test
	public void cadastrar() {
		Produto produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("produto TESTE");
		produto.setNome("produto de Java Backend");
		produto.setPreco(BigDecimal.valueOf(4500));
		produto = produtoDao.cadastrar(produto);
		
		assertNotNull(produto);
		assertNotNull(produto.getId());

		Produto produtoDB = produto;

		produtoDao.excluir(produtoDB);
	}

	@Test
	public void buscarTodosProdutos() {
		// Adicionando produtos
		Produto produto1 = new Produto();
		produto1.setCodigo("002");
		produto1.setNome("Produto 1");
		produto1.setDescricao("Descrição do Produto 1");
		produto1.setPreco(BigDecimal.valueOf(50.00));

		Produto produto2 = new Produto();
		produto2.setCodigo("003");
		produto2.setNome("Produto 2");
		produto2.setDescricao("Descrição do Produto 2");
		produto2.setPreco(BigDecimal.valueOf(150.00));

		produtoDao.cadastrar(produto1);
		produtoDao.cadastrar(produto2);

		// Buscando todos os produtos
		List<Produto> produtos = produtoDao.buscarTodos();

		// Verificando se os produtos foram corretamente recuperados
		assertNotNull(produtos);
		assertEquals(2, produtos.size());

		List<Produto> todosProdutos = produtoDao.buscarTodos();

		for (Produto prod : todosProdutos) {
			produtoDao.excluir(prod);
		}
	}


}
