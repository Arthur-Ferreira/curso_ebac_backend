package test.java.br.com.arthurferreira;

import main.java.br.com.arthurferreira.dao.IPedidoDao;
import main.java.br.com.arthurferreira.dao.PedidoDao;
import main.java.br.com.arthurferreira.domain.Categoria;
import main.java.br.com.arthurferreira.domain.Pedido;
import main.java.br.com.arthurferreira.domain.Produto;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.testng.AssertJUnit.assertNotNull;

public class PedidoTest {

  private IPedidoDao pedidoDao = new PedidoDao();

  @Test
  public void cadastrar() {

    Categoria categoria = new Categoria();
    categoria.setNome("Categoria Teste");

    Produto produto1 = new Produto();
    produto1.setCodigo("P1");
    produto1.setNome("Produto 1");
    produto1.setDescricao("Primeiro Produto de Testes");
    produto1.setPreco(BigDecimal.valueOf(25.99));
    produto1.setCategoria(categoria);

    Produto produto2 = new Produto();
    produto2.setCodigo("P2");
    produto2.setNome("Produto 2");
    produto2.setDescricao("Segundo Produto de Testes");
    produto2.setPreco(BigDecimal.valueOf(35.99));
    produto2.setCategoria(categoria);

    Set<Produto> produtos = new HashSet<>();
    produtos.add(produto1);
    produtos.add(produto2);

    Pedido pedido = new Pedido();
    pedido.setData(LocalDateTime.now());
    pedido.setProdutos(produtos);

    pedido = pedidoDao.cadastrar(pedido);

    assertNotNull(pedido);
    assertNotNull(pedido.getId());

    Pedido pedidoDB = pedido;

    pedidoDao.excluir(pedidoDB);
  }
}
