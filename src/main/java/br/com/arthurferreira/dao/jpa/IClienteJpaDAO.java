/**
 * 
 */
package main.java.br.com.arthurferreira.dao.jpa;

import main.java.br.com.arthurferreira.dao.generic.jpa.IGenericJapDAO;
import main.java.br.com.arthurferreira.domain.jpa.Persistente;

/**
 * @author arthur.ferreira
 *
 */
public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
