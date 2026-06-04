package el.development.ScienceAPI.ICD.symptoms;

import el.development.ScienceAPI.ICD.disorders.model.DisorderCreateDto;
import el.development.ScienceAPI.ICD.symptoms.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface SymptomRepository extends JpaRepository<Symptom, Long> {
}
