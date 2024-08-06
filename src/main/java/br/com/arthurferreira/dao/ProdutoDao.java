package main.java.br.com.arthurferreira.dao;

import main.java.br.com.arthurferreira.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDao implements IProdutoDao {

  EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("JpaAdvanced");

  @Override
  public Produto cadastrar(Produto produto) {

    EntityManager em = emf.createEntityManager();

    try {
      em.getTransaction().begin();
      em.persist(produto);
      em.getTransaction().commit();

    } catch (Exception err) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }

      err.printStackTrace();

    } finally {
      em.close();
    }

    return produto;
  }

  @Override
  public void excluir(Produto produto) {

    EntityManager em = emf.createEntityManager();

    try {

      em.getTransaction().begin();
      produto = em.merge(produto);
      em.remove(produto);
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
