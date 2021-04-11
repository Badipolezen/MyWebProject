package lastproject.lastdelivery.services.services.Impl;


import lastproject.lastdelivery.data.Role;
import lastproject.lastdelivery.repositories.RoleRepository;
import lastproject.lastdelivery.services.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;

@Service
public class RoeServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoeServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seedRolesInDb() {
this.roleRepository.saveAndFlush(new Role("ADMIN"));
this.roleRepository.saveAndFlush(new Role("USER"));
this.roleRepository.saveAndFlush(new Role("GUEST"));

    }
}
