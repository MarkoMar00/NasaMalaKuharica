package hr.tvz.nasamalakuharica.repository;

import hr.tvz.nasamalakuharica.domain.User;

import java.util.Optional;
import java.util.Set;

public interface UserRepository {
    Set<User> findAll();

    Optional<User> findByUsername(String username);

    Optional<User> save(User user);

    void deleteByUsername(String username);
}
