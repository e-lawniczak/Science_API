package el.development.ScienceAPI.common.auth;

import el.development.ScienceAPI.common.apiResponse.ApiException;
import el.development.ScienceAPI.common.apiResponse.ApiStatusCode;
import el.development.ScienceAPI.common.account.AccountService;
import el.development.ScienceAPI.common.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AccountService accountService;
    private final JwtUtil jwtUtil;

    public LoginResponseDto authenticateLogin(LoginDto login) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword()));
            var userDetails = accountService.loadUserByUsername(login.getLogin());
            var token = jwtUtil.generateToken(userDetails);

            accountService.saveUserToken(userDetails.getUsername(), token);

            return new LoginResponseDto(token);
        } catch (BadCredentialsException ex) {
            throw new ApiException(ApiStatusCode.INVALID_CREDENTIALS);
        }
    }

    public void logOut(String username) {
        accountService.saveUserToken(username, null);
    }
}
