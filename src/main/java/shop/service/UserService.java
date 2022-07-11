package shop.service;

import java.util.List;
import java.util.Optional;
import shop.model.User;

public interface UserService {
    Optional<User> findUserByEmail(String email);

    List<User> findAll();

    User save(User user);
}
