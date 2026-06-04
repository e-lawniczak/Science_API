package el.development.ScienceAPI.auth;

import el.development.ScienceAPI.models.Role;
import el.development.ScienceAPI.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private String phone;

    public UserDto(User user) {
        email = user.getEmail();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        role = user.getRole();
        phone = user.getPhone();
    }
}
