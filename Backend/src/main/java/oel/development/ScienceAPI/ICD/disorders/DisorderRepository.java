package oel.development.ScienceAPI.ICD.disorders;

import oel.development.ScienceAPI.ICD.disorders.model.Disorder;
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
