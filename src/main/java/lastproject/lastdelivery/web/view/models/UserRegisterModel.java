package lastproject.lastdelivery.web.view.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserRegisterModel {
//    private String officeName;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
}
