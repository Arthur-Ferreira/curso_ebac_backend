/**
 * 
 */
package main.java.br.com.arthurferreira.services;

import main.java.br.com.arthurferreira.dao.IProdutoDAO;
import main.java.br.com.arthurferreira.domain.Produto;
import main.java.br.com.arthurferreira.services.generic.GenericService;

/**
 * @author arthur.ferreira
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
