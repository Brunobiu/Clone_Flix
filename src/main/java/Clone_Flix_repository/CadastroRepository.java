package Clone_Flix_repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Clone_Flix_model.ModelLogin;

@Repository
public interface CadastroRepository extends CrudRepository<ModelLogin, Long> {
	
	/*Pessoa repository no curso*/
	
	@Query("select m from ModelLogin m where m.cpf = ?1")
	ModelLogin existeCpfCadastrado(String cpf);
}

