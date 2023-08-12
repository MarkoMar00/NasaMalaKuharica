package hr.tvz.nasamalakuharica.service;

import hr.tvz.nasamalakuharica.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();

    Optional<User> findByUsername(String username);

    User save(User user);
}
