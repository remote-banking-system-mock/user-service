package uz.developers.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.developers.user.domain.User;
import uz.developers.user.domain.UserCompany;
import uz.developers.user.dto.request.SaveUserRequest;
import uz.developers.user.dto.response.GetUserCompanyResponse;
import uz.developers.user.dto.response.GetUserResponse;

@Mapper(componentModel = "spring")
public interface UserCompanyMapper {
    @Mapping(target = "companyName", ignore = true)
    GetUserCompanyResponse toDto(UserCompany userCompany);

    @Mapping(target = "permissions", ignore = true)
    UserCompany toEntity(Long companyId, User user, Long roleId);
}
