package com.br.arthurferreira.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.br.arthurferreira.model.ProductModel;
import com.br.arthurferreira.repository.IProductRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class ProductController {

  @Autowired
  IProductRepository productRepository;

  @PostMapping("/products")
  public ResponseEntity<ProductModel> saveProduct(@RequestBody ProductModel productModel) {
    ProductModel savedProduct = productRepository.save(productModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
  }

  @GetMapping("/products")
  public ResponseEntity<List<ProductModel>> getAllProducts() {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productRepository.findAll());
  }

  @GetMapping("/products{id}")
  public ResponseEntity<Object> getSingleProduct(@PathVariable(value = "id") UUID id) {
    Optional<ProductModel> product = productRepository.findById(id);

    if (product.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Porduct not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body(product.get());
  }

  @PutMapping("/products/{id}")
  public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody String entity) {
    Optional<ProductModel> product = productRepository.findById(id);

    if (product.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Porduct not found");
    }

    var productModel = product.get();
    BeanUtils.copyProperties(entity, productModel);
    return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id) {
    Optional<ProductModel> product = productRepository.findById(id);

    if (product.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Porduct not found");
    }

    productRepository.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully!");
  }
}
