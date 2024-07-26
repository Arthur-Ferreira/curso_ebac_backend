/**
 * 
 */
package src.main.java.br.com.arthurferreira.services;

import src.main.java.br.com.arthurferreira.dao.IProdutoDAO;
import src.main.java.br.com.arthurferreira.domain.Produto;
import src.main.java.br.com.arthurferreira.services.generic.GenericService;

/**
 * @author arthur.ferreira
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
