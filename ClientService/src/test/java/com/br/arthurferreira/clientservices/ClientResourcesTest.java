package com.br.arthurferreira.clientservices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.br.arthurferreira.controller.ClientController;
import com.br.arthurferreira.model.ClientModel;
import com.br.arthurferreira.repository.IClientRepository;

public class ClientResourcesTest {

  @InjectMocks
  private ClientController clientController;

  @Mock
  private IClientRepository clientRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testSaveClient() {
    UUID clientId = UUID.randomUUID();
    ClientModel client = ClientModel.builder()
        .id(clientId)
        .name("Arthur Ferreira")
        .cpf("12345678901")
        .email("teste@teste.com")
        .address("Address")
        .phone("123456789")
        .city("RS")
        .state("RS")
        .build();

    when(clientRepository.save(client)).thenReturn(client);

    ResponseEntity<ClientModel> response = clientController.saveClient(client);

    assertThat(response.getStatusCodeValue()).isEqualTo(201);
    assertThat(response.getBody()).isEqualTo(client);
  }

  @Test
  void testGetAllClients() {
    ClientModel client1 = ClientModel.builder()
        .id(UUID.randomUUID())
        .name("Arthur Ferreira")
        .build();
    ClientModel client2 = ClientModel.builder()
        .id(UUID.randomUUID())
        .name("Arthur Ferreira 1")
        .build();

    List<ClientModel> clients = List.of(client1, client2);

    when(clientRepository.findAll()).thenReturn(clients);

    ResponseEntity<List<ClientModel>> response = clientController.getAllClients();

    assertThat(response.getStatusCodeValue()).isEqualTo(200);
    assertThat(response.getBody()).containsExactlyInAnyOrder(client1, client2);
  }

  @Test
  void testGetSingleClient() {
    UUID clientId = UUID.randomUUID();
    ClientModel client = ClientModel.builder()
        .id(clientId)
        .name("Arthur Ferreira")
        .build();

    when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));

    ResponseEntity<Object> response = clientController.getSingleClient(clientId);

    assertThat(response.getStatusCodeValue()).isEqualTo(200);
    assertThat(response.getBody()).isEqualTo(client);
  }

  @Test
  void testGetSingleClientNotFound() {
    UUID clientId = UUID.randomUUID();

    when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

    ResponseEntity<Object> response = clientController.getSingleClient(clientId);

    assertThat(response.getStatusCodeValue()).isEqualTo(404);
    assertThat(response.getBody()).isEqualTo("Client not found");
  }

  @Test
  void testUpdateClient() {
    UUID clientId = UUID.randomUUID();
    ClientModel existingClient = ClientModel.builder()
        .id(clientId)
        .name("Arthur Ferreira")
        .build();
    ClientModel updatedClient = ClientModel.builder()
        .id(clientId)
        .name("Arthur Ferreira 2")
        .build();

    when(clientRepository.findById(clientId)).thenReturn(Optional.of(existingClient));
    when(clientRepository.save(existingClient)).thenReturn(updatedClient);

    ResponseEntity<Object> response = clientController.updateClient(clientId, updatedClient);

    assertThat(response.getStatusCodeValue()).isEqualTo(200);
    assertThat(response.getBody()).isEqualTo(updatedClient);
  }

  @Test
  void testUpdateClientNotFound() {
    UUID clientId = UUID.randomUUID();
    ClientModel updatedClient = ClientModel.builder()
        .id(clientId)
        .name("Arthur Ferreira")
        .build();

    when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

    ResponseEntity<Object> response = clientController.updateClient(clientId, updatedClient);

    assertThat(response.getStatusCodeValue()).isEqualTo(404);
    assertThat(response.getBody()).isEqualTo("Client not found");
  }

  @Test
  void testDeleteClient() {
    UUID clientId = UUID.randomUUID();
    ClientModel client = ClientModel.builder()
        .id(clientId)
        .build();

    when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));
    doNothing().when(clientRepository).deleteById(clientId);

    ResponseEntity<Object> response = clientController.deleteClient(clientId);

    assertThat(response.getStatusCodeValue()).isEqualTo(200);
    assertThat(response.getBody()).isEqualTo("Client deleted successfully!");

    verify(clientRepository).deleteById(clientId);
  }
  
}
