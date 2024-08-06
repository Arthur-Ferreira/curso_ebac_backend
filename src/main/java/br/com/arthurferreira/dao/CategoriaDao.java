package main.java.br.com.arthurferreira.dao;

import main.java.br.com.arthurferreira.domain.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoriaDao implements ICategoriaDao{

  @Override
  public Categoria cadastrar(Categoria categoria) {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("JpaAdvanced");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    entityManager.persist(categoria);
    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();

    return categoria;
  }

  public void excluir(Categoria categoria) {
    EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("JpaAdvanced");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    entityManager.remove(categoria);
    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();
  }
}
