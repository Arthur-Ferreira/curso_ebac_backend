package com.br.arthurferreira.productservices;

import com.br.arthurferreira.controller.ProductController;
import com.br.arthurferreira.model.ProductModel;
import com.br.arthurferreira.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductResourcesTest {

  @Autowired
  private MockMvc mvc;

  @InjectMocks
  private ProductController productController;

  @Mock
  private IProductRepository productRepository;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    mvc = MockMvcBuilders.standaloneSetup(productController).build();
  }



  @Test
  void testSaveProduct() throws Exception {
    ProductModel productModel = ProductModel.builder()
        .idProduct(UUID.randomUUID())
        .code("PROD001")
        .name("Produto Teste")
        .description("Descrição do Produto Teste")
        .value(new BigDecimal("100.00"))
        .build();

    when(productRepository.save(productModel)).thenReturn(productModel);

    ResponseEntity<ProductModel> response = productController.saveProduct(productModel);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody()).isEqualTo(productModel);
  }

  @Test
  void testGetAllProducts() throws Exception {
    mvc.perform(get("/products"))
        .andExpect(status().isOk());
  }

  @Test
  void testGetSingleProduct() throws Exception {
    UUID id = UUID.randomUUID();
    ProductModel product = new ProductModel(id, "P001", "Product 1", "Description 1", new BigDecimal("10.00"));

    when(productRepository.findById(id)).thenReturn(Optional.of(product));

    ResponseEntity<Object> response = productController.getSingleProduct(id);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo(product);
  }

  @Test
  void testUpdateProduct() throws Exception {
    UUID id = UUID.randomUUID();
    ProductModel product = new ProductModel(id, "P001", "Product 1", "Description 1", new BigDecimal("10.00"));

    when(productRepository.findById(id)).thenReturn(Optional.of(product));
    when(productRepository.save(product)).thenReturn(product);

    ResponseEntity<Object> response = productController.updateProduct(id, String.valueOf(product));

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo(product);
  }

  @Test
  void testDeleteProduct() throws Exception {
    UUID id = UUID.randomUUID();
    when(productRepository.findById(id)).thenReturn(Optional.of(ProductModel.builder().idProduct(id).build()));

    doNothing().when(productRepository).deleteById(id);

    ResponseEntity<Object> response = productController.deleteProduct(id);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("Product deleted successfully!");
    verify(productRepository, times(1)).deleteById(id);
  }
}