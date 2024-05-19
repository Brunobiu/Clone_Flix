package Clone_Flix_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Clone_Flix_model.ModelLogin;

@Repository
@Transactional
public interface ModelRepository extends JpaRepository<ModelLogin, Long> {
	
	@Query("select a from model_login a where upper(trim(a.nome_sobrenome)) like %?1%")
	List<ModelLogin> buscarCadastro(String desc);

}
