package uz.developers.user.service.impl;

import org.springframework.stereotype.Service;
import uz.developers.rbs.exception.CustomException;
import uz.developers.user.domain.User;
import uz.developers.user.domain.UserCompany;
import uz.developers.user.dto.response.GetUserCompanyResponse;
import uz.developers.user.mapper.UserCompanyMapper;
import uz.developers.user.repository.UserCompanyRepository;
import uz.developers.user.repository.UserRepository;
import uz.developers.user.service.UserCompanyService;

import java.util.List;

import static uz.developers.user.dto.enumuration.ExceptionType.USER_NOT_FOUND;

@Service
public class UserCompanyServiceImpl implements UserCompanyService {
    private final UserCompanyRepository userCompanyRepository;
    private final UserCompanyMapper userCompanyMapper;
    private final UserRepository userRepository;

    public UserCompanyServiceImpl(UserCompanyRepository userCompanyRepository, UserCompanyMapper userCompanyMapper, UserRepository userRepository) {
        this.userCompanyRepository = userCompanyRepository;
        this.userCompanyMapper = userCompanyMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<GetUserCompanyResponse> findByUserId(Long userId) {
        return userCompanyRepository.findAllByUserId(userId).stream()
                .map(userCompanyMapper::toDto)
                .toList();
    }

    @Override
    public void link(Long companyId, Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        UserCompany userCompany = userCompanyMapper.toEntity(companyId, user, roleId);

        userCompanyRepository.save(userCompany);
    }
}
