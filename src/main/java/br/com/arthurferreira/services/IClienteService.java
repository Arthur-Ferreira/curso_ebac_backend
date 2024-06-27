package br.com.arthurferreira.services;

import br.com.arthurferreira.domain.Cliente;
import br.com.arthurferreira.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author arthur.ferreira
 */

public interface IClienteService {

  Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

  Cliente buscarPorCPF(Long cpf);

  void excluir(Long cpf);

  void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
