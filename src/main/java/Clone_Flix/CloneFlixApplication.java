package Clone_Flix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "Clone_Flix_model")
@ComponentScan(basePackages = {"Clone.*"})
@EnableJpaRepositories(basePackages = {"Clone_Flix_repository"})
@EnableTransactionManagement
public class CloneFlixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneFlixApplication.class, args);
	}

	
	// Aula Configurações de performance e teste de CRUD -33:02
}
