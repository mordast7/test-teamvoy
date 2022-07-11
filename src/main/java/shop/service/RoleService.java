package shop.service;

import shop.model.Role;

public interface RoleService {
    Role save(Role role);

    Role findByRoleName(Role.RoleName roleName);
}
