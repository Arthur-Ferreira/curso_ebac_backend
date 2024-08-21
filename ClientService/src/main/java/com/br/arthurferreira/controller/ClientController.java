package com.br.arthurferreira.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.br.arthurferreira.model.ClientModel;
import com.br.arthurferreira.repository.IClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class ClientController {

  @Autowired
  IClientRepository clientRepository;

  @PostMapping("/clients")
  public ResponseEntity<ClientModel> saveClient(@RequestBody ClientModel clientModel) {
    ClientModel savedClient = clientRepository.save(clientModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
  }

  @GetMapping("/clients")
  public ResponseEntity<List<ClientModel>> getAllClients() {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(clientRepository.findAll());
  }

  @GetMapping("/clients/{id}")
  public ResponseEntity<Object> getSingleClient(@PathVariable(value = "id") UUID id) {
    Optional<ClientModel> client = clientRepository.findById(id);

    if (client.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body(client.get());
  }

  @PutMapping("/clients/{id}")
  public ResponseEntity<Object> updateClient(@PathVariable(value = "id") UUID id, @RequestBody ClientModel entity) {
    Optional<ClientModel> client = clientRepository.findById(id);

    if (client.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
    }

    var clientModel = client.get();
    BeanUtils.copyProperties(entity, clientModel);
    return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(clientModel));
  }

  @DeleteMapping("/clients/{id}")
  public ResponseEntity<Object> deleteClient(@PathVariable(value = "id") UUID id) {
    Optional<ClientModel> client = clientRepository.findById(id);

    if (client.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
    }

    clientRepository.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body("Client deleted successfully!");
  }
}