package JavaDatabaseConnectivity.src.test.main.br.com.arthurferreira;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.produto.IProdutoDAO;
import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.produto.ProdutoDAO;
import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.domain.Produto;
import org.junit.Test;

import java.util.List;

public class ProdutoTest {

  @Test
  public void cadastrarTest() throws Exception {
    IProdutoDAO dao = new ProdutoDAO();

    Produto produto = new Produto();
    produto.setCodigo("01");
    produto.setNome("Bicicleta");
    produto.setDescricao("Bicicleta profissional, 16 marcas, banco ajustavel e amortecedores de primeira linha");
    produto.setPreco(2499.99f);

    Integer qtd = dao.cadastrar(produto);
    assertTrue(qtd == 1);

    Produto produtoBD = dao.consultar(produto.getCodigo());
    assertNotNull(produtoBD);
    assertNotNull(produtoBD.getId());
    assertEquals(produto.getCodigo(), produtoBD.getCodigo());
    assertEquals(produto.getNome(), produtoBD.getNome());
    assertEquals(produto.getDescricao(), produtoBD.getDescricao());
    assertEquals(produto.getPreco(), produtoBD.getPreco());

    Integer qtdDel = dao.excluir(produtoBD);
    assertNotNull(qtdDel);
  }

  @Test
  public void atualizarTest() throws Exception {
    IProdutoDAO dao = new ProdutoDAO();

    // Cadastro de Produto
    Produto produto = new Produto();
    produto.setCodigo("02");
    produto.setNome("Bicicleta A Motor");
    produto.setDescricao("Bicicleta com motor embutido, vá longe sem fazer muito esforço");
    produto.setPreco(5000.0f);

    Integer qtdCadastrada = dao.cadastrar(produto);
    assertTrue(qtdCadastrada == 1);

    // Atualização
    produto.setNome("Bicicleta A Motor Atualizada");
    produto.setDescricao("Bicicleta com motor embutido, vá longe sem fazer muito esforço. Atualização");
    produto.setPreco(7000.0f);

    Integer qtdAtualizada = dao.atualizar(produto);
    assertTrue(qtdAtualizada == 1);

    // Validar atualização
    Produto produtoBD = dao.consultar(produto.getCodigo());
    assertNotNull(produtoBD);
    assertEquals(produto.getNome(), produtoBD.getNome());
    assertEquals(produto.getDescricao(), produtoBD.getDescricao());
    assertEquals(produto.getPreco(), produtoBD.getPreco());

    Integer qtdDel = dao.excluir(produtoBD);
    assertNotNull(qtdDel);
  }

  @Test
  public void consultarTodosTest() throws Exception {
    IProdutoDAO dao = new ProdutoDAO();

    // Cadastro de produtos
    Produto produto1 = new Produto();
    produto1.setCodigo("03");
    produto1.setNome("Caneta");
    produto1.setDescricao("Caneta Bic azul, padrão ponta fina");
    produto1.setPreco(2.50f);
    dao.cadastrar(produto1);

    Produto produto2 = new Produto();
    produto2.setCodigo("04");
    produto2.setNome("Lapiseira");
    produto2.setDescricao("Lapiseira padrão, grifite 0.5");
    produto2.setPreco(4.50f);
    dao.cadastrar(produto2);

    // Consultar todos
    List<Produto> produtos = dao.consultarTodos();
    assertNotNull(produtos);
    assertTrue(produtos.size() > 1);

    int countDel = 0;
    for (Produto prod : produtos) {
      dao.excluir(prod);
      countDel++;
    }
    assertEquals(produtos.size(), countDel);

    produtos = dao.consultarTodos();
    assertEquals(produtos.size(), 0);

  }
}





















