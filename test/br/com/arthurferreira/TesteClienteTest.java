package test.br.com.arthurferreira;

import src.br.com.arthurferreira.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class TesteClienteTest {

  @Test
  public void testeMockCliente() {
    Cliente clienteMock = new Cliente(1, "MockCliente", "mock@cliente.com", "123456789");
    Assert.assertEquals("Cliente{id=1, nome='MockCliente', email='mock@cliente.com', telefone='123456789'}", clienteMock.toString());
  }
}