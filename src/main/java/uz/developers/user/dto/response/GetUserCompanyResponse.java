package uz.developers.user.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserCompanyResponse {
    private Long companyId;
    private String companyName;
    private Long roleId;

}
