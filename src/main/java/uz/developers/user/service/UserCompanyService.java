package uz.developers.user.service;

import uz.developers.user.dto.response.GetUserCompanyResponse;

import java.util.List;

public interface UserCompanyService {
    List<GetUserCompanyResponse> findByUserId(Long userId);

    void link(Long companyId, Long userId, Long roleId);
}
