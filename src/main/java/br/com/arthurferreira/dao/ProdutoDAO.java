package br.com.arthurferreira.dao;

import br.com.arthurferreira.dao.generic.GenericDAO;
import br.com.arthurferreira.domain.Produto;

/**
 * @author arthur.ferreira
 */

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

  public ProdutoDAO() {
    super();
  }

  @Override
  public Class<Produto> getTipoClasse() {
    return Produto.class;
  }

  @Override
  public void atualiarDados(Produto entity, Produto entityCadastrado) {
    entityCadastrado.setCodigo(entity.getCodigo());
    entityCadastrado.setDescricao(entity.getDescricao());
    entityCadastrado.setNome(entity.getNome());
    entityCadastrado.setValor(entity.getValor());
  }

}
