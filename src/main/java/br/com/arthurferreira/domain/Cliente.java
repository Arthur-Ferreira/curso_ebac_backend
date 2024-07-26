/**
 * 
 */
package src.main.java.br.com.arthurferreira.domain;

import src.main.java.anotacao.ColunaTabela;
import src.main.java.anotacao.Tabela;
import src.main.java.anotacao.TipoChave;
import src.main.java.br.com.arthurferreira.dao.Persistente;

/**
 * @author arthur.ferreira
 * Tarefas: Projeto 3 pt 2
 * - Adicionar um campo na tabela "Cliente";
 * - Alterar classe Cliente, Produto, DAOs;
 * - Criar novo teste para validar novo campo;
 * Bônus:
 * - Criar uma tabela de estoque e ligar ela as outras tabelas;
 */

@Tabela("TB_CLIENTE")
public class Cliente implements Persistente {
	
	@ColunaTabela(dbName = "id", setJavaName = "setId")
	private Long id;
	
	@ColunaTabela(dbName = "nome", setJavaName = "setNome")
	private String nome;
	
	@TipoChave("getCpf")
	@ColunaTabela(dbName = "cpf", setJavaName = "setCpf")
    private Long cpf;
    
	@ColunaTabela(dbName = "tel", setJavaName = "setTel")
    private Long tel;
    
	@ColunaTabela(dbName = "endereco", setJavaName = "setEnd")
    private String end;
    
	@ColunaTabela(dbName = "numero", setJavaName = "setNumero")
    private Integer numero;
    
	@ColunaTabela(dbName = "cidade", setJavaName = "setCidade")
    private String cidade;
    
	@ColunaTabela(dbName = "estado", setJavaName = "setEstado")
    private String estado;

	@ColunaTabela(dbName = "email", setJavaName = "setEmail")
		private String email;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
