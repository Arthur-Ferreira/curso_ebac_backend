package src.main.java.anotacao;

import java.lang.annotation.*;

/**
 * @author arthur.ferreira
 *
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColunaTabela {

	String dbName();
	
	String setJavaName();
}
