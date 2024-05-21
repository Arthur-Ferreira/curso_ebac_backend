package br.com.arthurferreira;

public class JuridicalPerson extends Person {
  private String cnpj;

  public JuridicalPerson(String name, String address, String cnpj) {
    super(name, address);

    this.cnpj = cnpj;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  @Override
  public String toString() {
    return super.toString() + " CNPJ: " + cnpj;
  }
}
