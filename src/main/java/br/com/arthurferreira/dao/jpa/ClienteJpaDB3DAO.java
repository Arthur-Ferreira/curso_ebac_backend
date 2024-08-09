/**
 * 
 */
package main.java.br.com.arthurferreira.dao.jpa;

import main.java.br.com.arthurferreira.dao.generic.jpa.GenericJpaDB3DAO;
import main.java.br.com.arthurferreira.domain.jpa.ClienteJpa2;

/**
 * @author arthur.ferreira
 *
 */
public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa2.class);
	}

}
