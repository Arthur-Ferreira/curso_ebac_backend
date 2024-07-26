package src.main.java.br.com.arthurferreira.dao;

/**
 * @author arthur.ferreira
 *
 * Classe que representa todas as entidades ou objetos da aplicação que seram salvas no banco de dados
 */
public interface Persistente {

	public Long getId();
	
	public void setId(Long id);
}
