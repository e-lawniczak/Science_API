package el.development.ScienceAPI.auth;

import el.development.ScienceAPI.apiResponse.ApiException;
import el.development.ScienceAPI.apiResponse.ApiResponse;
import el.development.ScienceAPI.apiResponse.ApiStatusCode;
import el.development.ScienceAPI.account.AccountService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

import static el.development.ScienceAPI.security.SecurityVars.AUTH_COOKIE_NAME;
import static el.development.ScienceAPI.security.SecurityVars.JWT_EXPIRATION;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AccountService accountService;
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody LoginDto loginDto, HttpServletResponse response){

        var login = authService.authenticateLogin(loginDto);

        ResponseCookie cookie = ResponseCookie.from(AUTH_COOKIE_NAME, login.getToken())
                .httpOnly(true)
//                .secure(true)
                .path("/")
                .maxAge(JWT_EXPIRATION)
                .sameSite(Cookie.SameSite.LAX.toString())
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return login;
    }

    @GetMapping("/logout")
    public void logout(HttpServletResponse response) {

        try{
            var login = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
            login.ifPresent(auth -> authService.logOut(auth.getName()));

            ResponseCookie cookie = ResponseCookie.from(AUTH_COOKIE_NAME, "")
                    .httpOnly(true)
                    .path("/")
                    .maxAge(0)
                    .sameSite(Cookie.SameSite.LAX.toString())
                    .build();

            response.addHeader("Set-Cookie", cookie.toString());

        } catch (Exception e) {
            log.error(e.getMessage(), Arrays.toString(e.getStackTrace()));
            throw new ApiException(ApiStatusCode.ERROR);
        }
    }

    @GetMapping("/me")
    public UserDto me() {

        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new ApiException(ApiStatusCode.UNAUTHORIZED);
        }

        return accountService.getUserDataByUsername(authentication.getName());
    }

}
