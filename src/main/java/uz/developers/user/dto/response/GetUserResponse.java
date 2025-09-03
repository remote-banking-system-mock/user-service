package uz.developers.user.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserResponse {
    private Long id;
    private String firstName;
    private String lastName;
}
