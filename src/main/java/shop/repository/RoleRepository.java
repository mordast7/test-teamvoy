package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(Role.RoleName roleName);
}
