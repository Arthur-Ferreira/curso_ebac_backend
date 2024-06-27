package br.com.arthurferreira;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.arthurferreira.dao.IProdutoDAO;
import br.com.arthurferreira.dao.ProdutoDAO;
import br.com.arthurferreira.domain.Produto;
import br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author arthur.ferreira
 */

public class ProdutoDAOTest {

  private IProdutoDAO produtoDao;

  private Produto produto;

  public ProdutoDAOTest() {
    produtoDao = new ProdutoDAO();
  }

  @Before
  public void init() throws TipoChaveNaoEncontradaException {
    produto = new Produto();
    produto.setCodigo("A1");
    produto.setDescricao("Produto 1");
    produto.setNome("Produto 1");
    produto.setValor(BigDecimal.TEN);
    produtoDao.cadastrar(produto);
  }

  @Test
  public void pesquisar() {
    Produto produto = this.produtoDao.consultar(this.produto.getCodigo());
    Assert.assertNotNull(produto);
  }

  @Test
  public void salvar() throws TipoChaveNaoEncontradaException {
    produto.setCodigo("A2");
    Boolean retorno = produtoDao.cadastrar(produto);
    Assert.assertTrue(retorno);
  }

  @Test
  public void excluir() {
    produtoDao.excluir(produto.getCodigo());
  }

  @Test
  public void alterarCliente() throws TipoChaveNaoEncontradaException {
    produto.setNome("Arthur Ferreira");
    produtoDao.alterar(produto);

    Assert.assertEquals("Arthur Ferreira", produto.getNome());
  }

  @Test
  public void buscarTodos() {
    Collection<Produto> list = produtoDao.buscarTodos();
    assertTrue(list != null);
    assertTrue(list.size() == 2);
  }
}
