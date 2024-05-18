package Clone_Flix_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Clone_Flix_model.ModelLogin;

@Repository
@Transactional
public interface ModelRepository extends JpaRepository<ModelLogin, Long> {

}
