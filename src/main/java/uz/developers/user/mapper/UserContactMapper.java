package uz.developers.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.developers.user.domain.User;
import uz.developers.user.domain.UserContact;
import uz.developers.user.dto.request.SaveUserRequest;

@Mapper(componentModel = "spring")
public interface UserContactMapper {

    @Mapping(target = "contact", source = "userRequest.phoneNumber")
    @Mapping(target = "status", constant = "NEW")
    @Mapping(target = "type", constant = "PHONE")
    UserContact toEntity(SaveUserRequest userRequest, User user);
}
