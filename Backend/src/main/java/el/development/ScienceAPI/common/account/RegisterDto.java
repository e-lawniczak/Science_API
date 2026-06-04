package el.development.ScienceAPI.common.account;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterDto {
    @NotEmpty
    public String firstName;
    @NotEmpty
    public String lastName;
    @NotEmpty
    @Email
    public String email;
    @Size(min=8, message = "Hasło musi mieć minium 8 znaków długości")
    public String password;
    @NotEmpty
    public String repeatPassword;
    public String phone;
}
