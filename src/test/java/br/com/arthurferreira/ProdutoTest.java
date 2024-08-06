package test.java.br.com.arthurferreira;

import main.java.br.com.arthurferreira.dao.CategoriaDao;
import main.java.br.com.arthurferreira.dao.ICategoriaDao;
import main.java.br.com.arthurferreira.dao.IProdutoDao;
import main.java.br.com.arthurferreira.dao.ProdutoDao;
import main.java.br.com.arthurferreira.domain.Categoria;
import main.java.br.com.arthurferreira.domain.Produto;
import org.junit.Test;


import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

public class ProdutoTest {

  private IProdutoDao produtoDao = new ProdutoDao();
  private ICategoriaDao categoriaDao = new CategoriaDao();


  @Test
  public void cadastrar() {
    Categoria categoria = new Categoria();
    categoria.setNome("Eletônicos");

    categoria = categoriaDao.cadastrar(categoria);


    Produto produto = new Produto();
    produto.setCodigo("P1");
    produto.setNome("Produto Teste");
    produto.setDescricao("Produto usado para teste o app");
    produto.setPreco(BigDecimal.valueOf(29.99));
    produto.setCategoria(categoria);

    produto = produtoDao.cadastrar(produto);

    assertNotNull(produto);
    assertNotNull(produto.getId());

    Produto produtoDB = produto;

    produtoDao.excluir(produtoDB);
  }
}
