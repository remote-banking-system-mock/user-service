package uz.developers.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.user.domain.UserCompany;

import java.util.List;

public interface UserCompanyRepository extends JpaRepository<UserCompany, Long> {
    List<UserCompany> findAllByUserId(Long userId);
}