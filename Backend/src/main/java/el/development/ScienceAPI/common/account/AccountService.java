package el.development.ScienceAPI.common.account;

import el.development.ScienceAPI.common.apiResponse.ApiException;
import el.development.ScienceAPI.common.apiResponse.ApiStatusCode;
import el.development.ScienceAPI.common.auth.UserDto;
import el.development.ScienceAPI.common.models.User;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public void createNewAccount(RegisterDto register) {
        if (!register.password.equals(register.repeatPassword))
           throw new ApiException(ApiStatusCode.PASSWORD_NO_MATCH);

        var user = accountRepository.findByEmail(register.email);
        if (user.isPresent())
            throw new ApiException(ApiStatusCode.EMAIL_EXISTS);
        try {
            var bCryptEncoder = new BCryptPasswordEncoder();

            User newUser = new User();
            newUser.setEmail(register.email);
            newUser.setFirstName(register.firstName);
            newUser.setLastName(register.lastName);
            newUser.setPassword(bCryptEncoder.encode(register.password));
            newUser.setPhone(register.phone);

            accountRepository.save(newUser);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new ApiException(ApiStatusCode.ERROR);
        }
    }

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = accountRepository.findByEmail(email);
        return user.map(value -> org.springframework.security.core.userdetails.User.withUsername(value.getEmail())
                .password(value.getPassword())
                .roles(value.getRole().toString())
                .build()).orElseThrow(()-> new ApiException(ApiStatusCode.UNAUTHORIZED));

    }

    public void saveUserToken(String username, String token) {
        var user = accountRepository.findByEmail(username);
        if (user.isEmpty())
            throw new ApiException(ApiStatusCode.USER_DOES_NOT_EXIST);

        user.get().setToken(token);
        accountRepository.save(user.get());
    }

    public UserDto getUserDataByUsername(String username) {
        return accountRepository.findByEmail(username)
                .map(UserDto::new)
                .orElseThrow(()-> new ApiException(ApiStatusCode.USER_DOES_NOT_EXIST));
    }
}
