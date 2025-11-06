package el.development.LabNotes.account;

import el.development.LabNotes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface AccountRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email) ;
}
