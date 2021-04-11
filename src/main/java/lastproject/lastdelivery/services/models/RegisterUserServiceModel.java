package lastproject.lastdelivery.services.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class RegisterUserServiceModel {

    private String username;

    private String firstName;

    private String lastName;

    private String password;
    private String confirmPassword;

//    private Set<RoleServiceModel> authorities;

}
