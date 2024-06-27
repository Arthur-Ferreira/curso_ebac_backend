package br.com.arthurferreira.dao;

import br.com.arthurferreira.dao.generic.GenericDAO;
import br.com.arthurferreira.domain.Cliente;

/**
 * @author arthur.ferreira
 */

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

  public ClienteDAO() {
    super();
  }

  @Override
  public Class<Cliente> getTipoClasse() {
    return Cliente.class;
  }

  @Override
  public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
    entityCadastrado.setCidade(entity.getCidade());
    entityCadastrado.setCpf(entity.getCpf());
    entityCadastrado.setEnd(entity.getEnd());
    entityCadastrado.setEstado(entity.getEstado());
    entityCadastrado.setNome(entity.getNome());
    entityCadastrado.setNumero(entity.getNumero());
    entityCadastrado.setTel(entity.getTel());

  }
}
