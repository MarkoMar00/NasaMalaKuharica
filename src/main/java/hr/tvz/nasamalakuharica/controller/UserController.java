package hr.tvz.nasamalakuharica.controller;

import hr.tvz.nasamalakuharica.dto.UserDto;
import hr.tvz.nasamalakuharica.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping("all")
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/")
    public ResponseEntity<UserDto> getUserByUserName(@RequestParam String username){
        return userService.findByUsername(username)
                .map(
                        user -> ResponseEntity.status(HttpStatus.FOUND).body(user)
                ).orElseGet(
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                );
    }

    @PostMapping("/create")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }
}
