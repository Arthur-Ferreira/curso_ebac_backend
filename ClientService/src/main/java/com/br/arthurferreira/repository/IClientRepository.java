package com.br.arthurferreira.repository;

import java.util.UUID;

import com.br.arthurferreira.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientModel, UUID> {


}
