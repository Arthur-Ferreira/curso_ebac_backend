package src.main.java.br.com.arthurferreira.dao;

import src.main.java.br.com.arthurferreira.dao.generic.IGenericDAO;
import src.main.java.br.com.arthurferreira.domain.Venda;
import src.main.java.br.com.arthurferreira.exceptions.DAOException;
import src.main.java.br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author arthur.ferreira
 */

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
