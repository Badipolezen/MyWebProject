package lastproject.lastdelivery.services.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class UserServiceModel {
    private String username;
    private String password;
    private Set<RoleServiceModel> authorities;

}
