package hr.tvz.nasamalakuharica.service.impl;

import hr.tvz.nasamalakuharica.domain.User;
import hr.tvz.nasamalakuharica.dto.UserDto;
import hr.tvz.nasamalakuharica.repository.UserRepository;
import hr.tvz.nasamalakuharica.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll()
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return Optional.of(mapToDto(userRepository.findByUsername(username).get()));
    }

    @Override
    public UserDto save(UserDto userDto) {
        return mapToDto(userRepository.save(mapToUser(userDto)));
    }

    private User mapToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        return user;
    }

    private UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
