package el.development.LabNotes.user;

import el.development.LabNotes.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends  JpaRepository<User, Long> {
}
