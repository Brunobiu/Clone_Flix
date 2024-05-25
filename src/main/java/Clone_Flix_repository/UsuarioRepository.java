package Clone_Flix_repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Clone_Flix_model.ModelLogin;

@Repository
public interface UsuarioRepository extends CrudRepository<ModelLogin, Long> {
	
	@Query("SELECT u FROM ModelLogin u WHERE u.nomeSobrenome = ?1")
	ModelLogin findUserByLogin(String nomeSobrenome);

	@Query("SELECT u FROM ModelLogin u WHERE u.id = ?1 OR u.email = ?2")
	ModelLogin findUserByPessoa(Long id, String email);
}
