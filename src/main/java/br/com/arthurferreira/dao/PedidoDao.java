package main.java.br.com.arthurferreira.dao;

import main.java.br.com.arthurferreira.domain.Pedido;
import main.java.br.com.arthurferreira.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PedidoDao implements IPedidoDao {

  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaAdvanced");

  @Override
  public Pedido cadastrar(Pedido pedido) {

    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();

      for (Produto produto : pedido.getProdutos()) {
        if (produto.getCategoria() != null && produto.getCategoria().getId() == null) {
          em.persist(produto.getCategoria());
        }

        if (produto.getId() == null) {
          em.persist(produto);
        } else {
          em.merge(produto);
        }
      }

      em.persist(pedido);
      em.getTransaction().commit();

    } catch (Exception err) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      err.printStackTrace();
    } finally {
      em.close();
    }
    return pedido;
  }

  @Override
  public void excluir(Pedido pedido) {

    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();
      pedido = em.merge(pedido);
      em.remove(pedido);
      em.getTransaction().commit();

    } catch (Exception err) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }

      err.printStackTrace();

    } finally {
      em.close();
    }
  }
}
