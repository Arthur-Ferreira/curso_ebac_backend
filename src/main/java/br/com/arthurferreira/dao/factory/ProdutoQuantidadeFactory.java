/**
 * 
 */
package main.java.br.com.arthurferreira.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.arthurferreira.domain.Produto;
import br.com.arthurferreira.domain.ProdutoQuantidade;

/**
 * @author arthur.ferreira
 *
 */
public class ProdutoQuantidadeFactory {

	public static ProdutoQuantidade convert(ResultSet rs) throws SQLException {
		Produto prod = ProdutoFactory.convert(rs);
		ProdutoQuantidade prodQ = new ProdutoQuantidade();
		prodQ.setProduto(prod);
		prodQ.setId(rs.getLong("ID"));
		prodQ.setQuantidade(rs.getInt("QUANTIDADE"));
		prodQ.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
		return prodQ;
	}
}
