package lastproject.lastdelivery.web.view.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginModel {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
