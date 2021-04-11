package lastproject.lastdelivery.services.services;


import lastproject.lastdelivery.data.User;
import lastproject.lastdelivery.services.models.UsersServiceModel;

import java.util.List;

public interface UserService  {
    List<UsersServiceModel> getAll();
    User findByUsername(String username);
    void changeRole(String username);
}


