/**
 * 
 */
package main.java.br.com.arthurferreira.dao;

import main.java.br.com.arthurferreira.dao.generic.IGenericDAO;
import main.java.br.com.arthurferreira.domain.Venda;
import main.java.br.com.arthurferreira.exceptions.DAOException;
import main.java.br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author arthur.ferreira
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
