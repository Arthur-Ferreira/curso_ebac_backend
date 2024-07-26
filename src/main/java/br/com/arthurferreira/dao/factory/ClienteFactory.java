/**
 * 
 */
package src.main.java.br.com.arthurferreira.dao.factory;

import src.main.java.br.com.arthurferreira.domain.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author arthur.ferreira
 *
 */
public class ClienteFactory {

	public static Cliente convert(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getLong("ID_CLIENTE"));
		cliente.setNome(rs.getString(("NOME")));
		cliente.setCpf(rs.getLong(("CPF")));
		cliente.setTel(rs.getLong(("TEL")));
		cliente.setEnd(rs.getString(("ENDERECO")));
		cliente.setNumero(rs.getInt(("NUMERO")));
		cliente.setCidade(rs.getString(("CIDADE")));
		cliente.setEstado(rs.getString(("ESTADO")));
		cliente.setEmail(rs.getString(("EMAIL")));
		return cliente;
	}
}
