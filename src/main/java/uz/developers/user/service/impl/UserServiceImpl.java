package uz.developers.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.developers.rbs.exception.CustomException;
import uz.developers.user.domain.User;
import uz.developers.user.domain.UserContact;
import uz.developers.user.dto.request.SaveUserRequest;
import uz.developers.user.dto.response.GetUserResponse;
import uz.developers.user.mapper.UserContactMapper;
import uz.developers.user.mapper.UserMapper;
import uz.developers.user.repository.UserContactRepository;
import uz.developers.user.repository.UserRepository;
import uz.developers.user.service.UserService;

import static uz.developers.user.dto.enumuration.ExceptionType.PHONE_NUMBER_ALREADY_USED;
import static uz.developers.user.dto.enumuration.ExceptionType.USER_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserContactRepository userContactRepository;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UserContactMapper userContactMapper;

    @Override
    public Long save(SaveUserRequest userRequest) {
        userContactRepository.findByContact(userRequest.getPhoneNumber()).ifPresent(userContact -> {
            throw new CustomException(PHONE_NUMBER_ALREADY_USED);
        });

        User user = userMapper.toEntity(userRequest);

        userRepository.save(user);

        UserContact userContact = userContactMapper.toEntity(userRequest, user);

        userContactRepository.save(userContact);

        return user.getId();
    }

    @Override
    public GetUserResponse findById(Long id) {
       return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new CustomException(USER_NOT_FOUND));
    }
}
