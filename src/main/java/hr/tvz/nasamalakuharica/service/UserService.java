package hr.tvz.nasamalakuharica.service;

import hr.tvz.nasamalakuharica.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAllUsers();

    Optional<UserDto> findByUsername(String username);

    Optional<UserDto> save(UserDto userDto);
}
