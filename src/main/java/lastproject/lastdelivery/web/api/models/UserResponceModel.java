package lastproject.lastdelivery.web.api.models;

import lastproject.lastdelivery.data.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponceModel {
    private String officeName;

    private String username;

    private String firstName;

    private String lastName;

    private String password;
    private Set<Role> authorities;

}
