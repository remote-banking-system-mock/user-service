package uz.developers.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.user.domain.UserContact;

import java.util.Optional;

public interface UserContactRepository extends JpaRepository<UserContact, Long> {
    Optional<UserContact> findByContact(String contact);
}