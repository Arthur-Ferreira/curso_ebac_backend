package JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.cliente;

import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.jdbc.ConnectionFactory;
import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arthur.ferreira
 */

public class ClienteDAO implements IClienteDAO {
		Connection connection = null;
		PreparedStatement stm = null;

	@Override
	public Integer cadastrar(Cliente cliente) throws Exception {
		String sql = "INSERT INTO clientes (ID, CODIGO, NOME) VALUES (nextval('SQ_CLIENTES'),?,?)";

		try {
			connection = ConnectionFactory.getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			stm.setString(2, cliente.getNome());
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Cliente consultar(String codigo) throws Exception {
		ResultSet rs = null;
		Cliente cliente = null;
		String sql = "SELECT * FROM clientes WHERE codigo = ?";

		try {
			connection = ConnectionFactory.getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNome(rs.getString("nome"));
			}
			return cliente;
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Integer excluir(Cliente cliente) throws Exception {
		String sql = "DELETE FROM clientes WHERE codigo = ?";

		try {
			connection = ConnectionFactory.getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Integer atualizar(Cliente cliente) throws Exception {
		String sql = "UPDATE clientes SET nome = ? WHERE codigo = ?";

		try {
			connection = ConnectionFactory.getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCodigo());
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public List<Cliente> consultarTodos() throws Exception {
		List<Cliente> clientes = new ArrayList<>();
		ResultSet rs = null;
		String sql = "SELECT * FROM clientes";

		try {
			connection = ConnectionFactory.getConnection();
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();

			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNome(rs.getString("nome"));
				clientes.add(cliente);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
		}
	}

	return clientes;
	}
}