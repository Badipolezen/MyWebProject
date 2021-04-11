package lastproject.lastdelivery.web.view.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor

public class WebUserRegisterModel {


    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String confirmPassword;
}
