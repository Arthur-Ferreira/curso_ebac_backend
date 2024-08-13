package br.com.arthurferreira.SpringBootFirstEx.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.arthurferreira.SpringBootFirstEx.domain.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long> {

}
