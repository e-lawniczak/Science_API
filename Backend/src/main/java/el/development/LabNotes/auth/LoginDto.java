package el.development.LabNotes.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto {
    @NotEmpty
    @Email
    private String login;
    @NotEmpty
    private String password;

}
