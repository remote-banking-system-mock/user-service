package uz.developers.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.developers.user.domain.User;
import uz.developers.user.dto.request.SaveUserRequest;
import uz.developers.user.dto.response.GetUserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "status", constant = "NEW")
    User toEntity(SaveUserRequest userRequest);

    GetUserResponse toDto(User user);
}
