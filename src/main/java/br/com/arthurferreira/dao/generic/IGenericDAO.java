package br.com.arthurferreira.dao.generic;

import br.com.arthurferreira.dao.Persistente;
import br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author arthur.ferreira
 */

public interface IGenericDAO<T extends Persistente, E extends Serializable> {

  public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

  public void excluir(E valor);

  public void alterar(T entity) throws TipoChaveNaoEncontradaException;

  public T consultar(E valor);

  public Collection<T> buscarTodos();
}
