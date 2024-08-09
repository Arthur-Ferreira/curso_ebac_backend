/**
 * 
 */
package main.java.br.com.arthurferreira.dao.jpa;

import main.java.br.com.arthurferreira.dao.generic.jpa.GenericJpaDB1DAO;
import main.java.br.com.arthurferreira.domain.jpa.ProdutoJpa;

/**
 * @author arthur.ferreira
 *
 */
public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
