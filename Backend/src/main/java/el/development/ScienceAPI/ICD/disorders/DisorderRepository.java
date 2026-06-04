package el.development.ScienceAPI.ICD.disorders;

import el.development.ScienceAPI.ICD.disorders.model.Disorder;
import el.development.ScienceAPI.common.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface DisorderRepository extends JpaRepository<Disorder, Long> {
    boolean existsByCode(String code);

    Optional<Disorder> findByCode(String code);
}
