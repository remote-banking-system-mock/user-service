package uz.developers.user.service;

import uz.developers.user.dto.request.SaveUserRequest;
import uz.developers.user.dto.response.GetUserResponse;

public interface UserService {
    Long save(SaveUserRequest userRequest);

    GetUserResponse findById(Long id);
}
