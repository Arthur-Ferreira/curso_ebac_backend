/**
 * 
 */
package main.java.br.com.arthurferreira.dao.factory;

import main.java.br.com.arthurferreira.domain.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author arthur.ferreira
 *
 */
public class ProdutoFactory {

	
	public static Produto convert(ResultSet rs) throws SQLException {
		Produto prod = new Produto();
		prod.setId(rs.getLong("ID_PRODUTO"));
		prod.setCodigo(rs.getString("CODIGO"));
		prod.setNome(rs.getString("NOME"));
		prod.setDescricao(rs.getString("DESCRICAO"));
		prod.setValor(rs.getBigDecimal("VALOR"));
		return prod;
	}
}
