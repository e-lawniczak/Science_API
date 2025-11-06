package el.development.LabNotes.auth;

import el.development.LabNotes.ApiResponse;
import el.development.LabNotes.ApiStatusCode;
import el.development.LabNotes.account.AccountRepository;
import el.development.LabNotes.account.AccountService;
import el.development.LabNotes.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;
    @Autowired
    private JwtUtil jwtUtil;

    public ApiResponse<LoginResponseDto> authenticateLogin(LoginDto login) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword()));
            var userDetails = accountService.loadUserByUsername(login.getLogin());
            var token = jwtUtil.generateToken(userDetails);

            accountService.saveUserToken(userDetails.getUsername(), token);

            LoginResponseDto loginResponseDto = new LoginResponseDto(token);

            return new ApiResponse<>(ApiStatusCode.OK, loginResponseDto);
        } catch (BadCredentialsException ex) {
            return new ApiResponse<>(ApiStatusCode.INVALID_CREDENTIALS);
        }
    }
}
