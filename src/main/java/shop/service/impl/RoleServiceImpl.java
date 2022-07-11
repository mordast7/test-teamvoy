package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.model.Role;
import shop.repository.RoleRepository;
import shop.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByRoleName(Role.RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
