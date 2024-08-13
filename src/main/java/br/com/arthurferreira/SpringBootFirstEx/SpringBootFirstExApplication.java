package br.com.arthurferreira.SpringBootFirstEx;

import br.com.arthurferreira.SpringBootFirstEx.domain.Cliente;
import br.com.arthurferreira.SpringBootFirstEx.repository.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.arthurferreira.repository")
@EntityScan("br.com.arthurferreira.*")
@ComponentScan(basePackages = "br.com.arthurferreira")
public class SpringBootFirstExApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootFirstExApplication.class);

	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstExApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("Porto Alegre")
				.cpf(12312317890L)
				.email("Arthur.Ferreira@teste.com")
				.endereco("Av. Assis Brasil")
				.estado("RS")
				.nome("Arthur Ferreira")
				.numero(102030)
				.tel(10203040L)
				.build();
	}

}
