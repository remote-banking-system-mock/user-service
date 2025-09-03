package uz.developers.user.dto.enumuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType implements uz.developers.rbs.exception.ExceptionType {
    PHONE_NUMBER_ALREADY_USED(1000, "This phone number is already used"),
    USER_NOT_FOUND(1001, "User not found by given id"),
    ;
    private final int code;
    private final String message;
}
