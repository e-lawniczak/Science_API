package el.development.LabNotes.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import static el.development.LabNotes.security.SecurityVars.AUTH_COOKIE_NAME;
import static el.development.LabNotes.security.SecurityVars.JWT_EXPIRATION;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginDto loginDto, HttpServletResponse response){

        var login = authService.authenticateLogin(loginDto);

        ResponseCookie cookie = ResponseCookie.from(AUTH_COOKIE_NAME, login.getReturnObject().getToken())
                .httpOnly(true)
//                .secure(true)
                .path("/")
                .maxAge(JWT_EXPIRATION)
                .sameSite(Cookie.SameSite.STRICT.toString())
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return new ResponseEntity<>(login.getReturnObject(), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hi(HttpServletRequest request){

        return new ResponseEntity<>("Hello " + request.getServletPath(), HttpStatus.OK);
    }

}
