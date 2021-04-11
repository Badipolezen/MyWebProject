package lastproject.lastdelivery.repositories;

import lastproject.lastdelivery.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findByUsername(String username);
    boolean existsByUsername( String username);
    boolean existsByUsernameAndPassword( String username,String password);
    User findUserById(String id);

}

