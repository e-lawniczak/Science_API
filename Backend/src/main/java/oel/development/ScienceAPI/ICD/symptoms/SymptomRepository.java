package oel.development.ScienceAPI.ICD.symptoms;

import oel.development.ScienceAPI.ICD.symptoms.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface SymptomRepository extends JpaRepository<Symptom, Long> {
}
