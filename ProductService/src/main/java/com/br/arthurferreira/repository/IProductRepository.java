package com.br.arthurferreira.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.arthurferreira.model.ProductModel;

@Repository
public interface IProductRepository extends JpaRepository<ProductModel, UUID> {


}
