/**
 * 
 */
package main.java.br.com.arthurferreira.dao.jpa;

import main.java.br.com.arthurferreira.dao.generic.jpa.GenericJpaDB2DAO;
import main.java.br.com.arthurferreira.domain.jpa.ClienteJpa;

/**
 * @author arthur.ferreira
 *
 */
public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}

}
