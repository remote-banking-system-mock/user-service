package uz.developers.user.dto.request;

import lombok.Data;

@Data
public class SaveUserRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
