package lastproject.lastdelivery.services.models;

import lastproject.lastdelivery.data.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersServiceModel {

    private String officeName;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private Set<Role> authorities;
}
