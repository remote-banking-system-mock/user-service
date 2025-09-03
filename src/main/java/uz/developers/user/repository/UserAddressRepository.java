package uz.developers.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.user.domain.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
}