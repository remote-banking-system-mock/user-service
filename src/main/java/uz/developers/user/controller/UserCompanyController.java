package uz.developers.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.rbs.dto.response.BaseResponse;
import uz.developers.user.service.UserCompanyService;

@RestController
@RequestMapping("/v1/companies")
@RequiredArgsConstructor
public class UserCompanyController {

    private final UserCompanyService userCompanyService;

    @PostMapping("/{companyId}/link")
    public ResponseEntity<BaseResponse<Void>> getUser(@PathVariable Long companyId,
                                                      @RequestParam Long userId,
                                                      @RequestParam Long roleId) {
        userCompanyService.link(companyId, userId, roleId);
        return ResponseEntity.ok(BaseResponse.success(null));
    }
}
