package el.development.ScienceAPI.account;

import el.development.ScienceAPI.apiResponse.ApiResponse;
import el.development.ScienceAPI.apiResponse.ApiStatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ApiResponse<Void> registerAccount(@RequestBody RegisterDto register) {
        accountService.createNewAccount(register);
        return new ApiResponse<>(ApiStatusCode.OK);
    }
}
