package lastproject.lastdelivery.services.models;

import lastproject.lastdelivery.data.Role;
import lastproject.lastdelivery.repositories.RoleRepository;
import lastproject.lastdelivery.services.services.RoleService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor

public class RoleServiceModel {

    private String authority;

}
