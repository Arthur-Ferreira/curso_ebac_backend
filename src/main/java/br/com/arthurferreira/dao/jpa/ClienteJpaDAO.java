/**
 * 
 */
package main.java.br.com.arthurferreira.dao.jpa;

import br.com.arthurferreira.dao.generic.jpa.GenericJpaDAO;
import br.com.arthurferreira.domain.jpa.ClienteJpa;

/**
 * @author arthur.ferreira
 *
 */
public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
