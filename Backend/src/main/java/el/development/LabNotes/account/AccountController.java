package el.development.ScienceAPI.account;

import el.development.ScienceAPI.ApiResponse;
import el.development.ScienceAPI.ApiStatusCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@RequestBody RegisterDto register) {
        var registerUser = accountService.createNewAccount(register);

        if (registerUser.getCode().equals(ApiStatusCode.OK))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(registerUser.getCode().getMsg() + " Kod: " + registerUser, HttpStatus.BAD_REQUEST);

    }
}
