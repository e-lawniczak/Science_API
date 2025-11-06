package el.development.LabNotes.account;

import el.development.LabNotes.ApiStatusCode;
import el.development.LabNotes.ApiResponse;
import el.development.LabNotes.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    public ApiResponse<String> createNewAccount(RegisterDto register) {
        if (!register.password.equals(register.repeatPassword))
            return new ApiResponse<>(ApiStatusCode.PASSWORD_NO_MATCH);

        var user = accountRepository.findByEmail(register.email);
        if (user.isPresent())
            return new ApiResponse<>(ApiStatusCode.EMAIL_EXISTS);
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
            return new ApiResponse<>(ApiStatusCode.ERROR);
        }

        return new ApiResponse<>(ApiStatusCode.OK);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = accountRepository.findByEmail(email);
        if (user.isEmpty())
            return null;

        return org.springframework.security.core.userdetails.User.withUsername(user.get().getEmail())
                .password(user.get().getPassword())
                .roles(user.get().getRole().toString())
                .build();

    }

    public void saveUserToken(String username, String token) {
        var user = accountRepository.findByEmail(username);
        if (user.isEmpty())
            return;

        user.get().setToken(token);
        accountRepository.save(user.get());
    }
}
