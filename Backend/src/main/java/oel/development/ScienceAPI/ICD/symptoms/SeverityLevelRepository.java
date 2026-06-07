package oel.development.ScienceAPI.ICD.symptoms;

import oel.development.ScienceAPI.ICD.symptoms.model.SeverityLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface SeverityLevelRepository extends JpaRepository<SeverityLevel, Long> {
}
