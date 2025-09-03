package uz.developers.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}