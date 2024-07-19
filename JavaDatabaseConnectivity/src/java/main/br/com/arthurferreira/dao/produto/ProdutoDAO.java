package JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.jdbc.ConnectionFactory;
import JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.domain.Produto;

/**
 * @author arthur.ferreira
 *
 */
public class ProdutoDAO implements IProdutoDAO {
	Connection connection = null;
	PreparedStatement stm = null;

	@Override
	public Integer cadastrar(Produto produto) throws Exception {
		String sql = "INSERT INTO produtos (id, codigo, nome, descricao, preco) VALUES (nextval('SQ_PRODUTO'),?,?,?,?)";

		try {
			connection = ConnectionFactory.getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getCodigo());
			stm.setString(2, produto.getNome());
			stm.setString(3, produto.getDescricao());
			stm.setFloat(4, produto.getPreco());
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
	public Produto consultar(String codigo) throws Exception {
		ResultSet rs = null;
		Produto produto = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM produtos WHERE codigo = ?";
			stm = connection.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getFloat("preco"));
			}
			return produto;
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
	public Integer excluir(Produto produto) throws Exception {
		String sql = "DELETE FROM produtos WHERE codigo = ?";

		try {
			connection = ConnectionFactory.getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getCodigo());
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
	public List<Produto> consultarTodos() throws Exception {
		List<Produto> produtos = new ArrayList<>();
		ResultSet rs = null;
		String sql = "SELECT * FROM produtos";

		try {
			connection = ConnectionFactory.getConnection();
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getFloat("preco"));
				produtos.add(produto);
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
		return produtos;
	}

	@Override
	public Integer atualizar(Produto produto) throws Exception {
		String sql = "UPDATE produtos SET nome = ?, descricao = ?, preco = ? WHERE codigo = ?";

		try {
			connection = ConnectionFactory.getConnection();
			stm = connection.prepareStatement(sql);
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.setFloat(3, produto.getPreco());
			stm.setString(4, produto.getCodigo());
			return stm.executeUpdate();
		} catch (Exception e) {
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

}
