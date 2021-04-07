package lastproject.lastdelivery.repositories;

import lastproject.lastdelivery.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByAuthority(String auth);
}
