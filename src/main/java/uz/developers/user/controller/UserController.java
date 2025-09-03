package uz.developers.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.rbs.dto.response.BaseResponse;
import uz.developers.user.dto.request.SaveUserRequest;
import uz.developers.user.dto.response.GetUserCompanyResponse;
import uz.developers.user.dto.response.GetUserResponse;
import uz.developers.user.service.UserCompanyService;
import uz.developers.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserCompanyService userCompanyService;

    @PostMapping
    public ResponseEntity<BaseResponse<Long>> saveUser(@RequestBody SaveUserRequest saveUserRequest) {
        Long userId = userService.save(saveUserRequest);
        return ResponseEntity.ok(BaseResponse.success(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<GetUserResponse>> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(BaseResponse.success(userService.findById(id)));
    }

    @GetMapping("/{userId}/companies")
    public ResponseEntity<BaseResponse<List<GetUserCompanyResponse>>> getUserCompanies(@PathVariable Long userId) {
        return ResponseEntity.ok(BaseResponse.success(userCompanyService.findByUserId(userId)));
    }
}
