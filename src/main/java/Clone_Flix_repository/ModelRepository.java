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

    @Query("select a from ModelLogin a where upper(trim(a.nomeSobrenome)) like %?1%")
    List<ModelLogin> buscarPorModel(String nome);
}

