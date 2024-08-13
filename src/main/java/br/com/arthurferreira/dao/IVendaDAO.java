package br.com.arthurferreira.dao;

import br.com.arthurferreira.dao.generic.IGenericDAO;
import br.com.arthurferreira.domain.Venda;
import br.com.arthurferreira.exceptions.DAOException;
import br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, Long>{

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

	public Venda consultarComCollection(Long id);

}
