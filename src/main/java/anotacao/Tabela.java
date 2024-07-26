/**
 * 
 */
package src.main.java.anotacao;

import java.lang.annotation.*;

/**
 * @author arthur.ferreira
 *
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

	String value();
}
