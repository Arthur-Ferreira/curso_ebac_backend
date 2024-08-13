package br.com.arthurferreira.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.arthurferreira.domain.Persistente;
import br.com.arthurferreira.exceptions.DAOException;
import br.com.arthurferreira.exceptions.MaisDeUmRegistroException;
import br.com.arthurferreira.exceptions.TableException;
import br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericService<T extends Persistente, E extends Serializable> {


  public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

  public void excluir(T entity) throws DAOException;

  public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;


  public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;


  public Collection<T> buscarTodos() throws DAOException;

}
