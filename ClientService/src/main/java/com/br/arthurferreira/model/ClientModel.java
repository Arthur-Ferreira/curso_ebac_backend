package com.br.arthurferreira.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_clients", indexes = {
    @Index(name = "idx_client_id", columnList = "id", unique = true)
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClientModel implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "name", nullable = false)
  private String name;

  @NotNull
  @Column(name = "cpf", nullable = false, unique = true)
  private String cpf;

  @Column(name = "phone", nullable = false)
  private String phone;

  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "email", nullable = false, length = 100)
  private String email;

  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "address", nullable = false, length = 255)
  private String address;

  @NotNull
  @Digits(integer = 10, fraction = 0)
  @Column(name = "number", nullable = false)
  private Integer number;

  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "city", nullable = false, length = 100)
  private String city;

  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "state", nullable = false, length = 50)
  private String state;
}