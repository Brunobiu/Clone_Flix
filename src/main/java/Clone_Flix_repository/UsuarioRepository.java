package Clone_Flix_repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Clone_Flix_model.ModelLogin;

@Repository
public interface UsuarioRepository extends CrudRepository<ModelLogin, Long> {
	
	@Query(value = "select u from ModelLogin u where u.nomeSobrenome = ?1")
	ModelLogin findUserByLogin(String nomeSobrenome);

}
