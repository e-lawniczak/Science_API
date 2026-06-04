package el.development.ScienceAPI.common.account;

import el.development.ScienceAPI.common.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface AccountRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email) ;
}
