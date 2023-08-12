package hr.tvz.nasamalakuharica.controller;

import hr.tvz.nasamalakuharica.domain.User;
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
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/")
    public ResponseEntity<User> getUserByUserName(@RequestParam String username){
        return userService.findByUsername(username)
                .map(
                        user -> ResponseEntity.status(HttpStatus.FOUND).body(user)
                ).orElseGet(
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                );
    }

    @PostMapping("/create")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }
}
