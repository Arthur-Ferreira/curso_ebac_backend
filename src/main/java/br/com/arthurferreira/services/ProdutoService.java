package br.com.arthurferreira.services;

import br.com.arthurferreira.dao.IProdutoDAO;
import br.com.arthurferreira.domain.Produto;
import br.com.arthurferreira.services.generic.GenericService;

/**
 * @author arthur.ferreira
 */

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

  public ProdutoService(IProdutoDAO dao) {
    super(dao);
  }

}
