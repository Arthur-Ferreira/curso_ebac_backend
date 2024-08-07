/**
 * 
 */
package main.java.br.com.arthurferreira.dao.jpa;

import br.com.arthurferreira.dao.generic.jpa.GenericJpaDAO;
import br.com.arthurferreira.domain.jpa.ProdutoJpa;

/**
 * @author arthur.ferreira
 *
 */
public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
