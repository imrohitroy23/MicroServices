package com.example.userService.userService.Controller;

import com.example.userService.userService.Services.UserService;
import com.example.userService.userService.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User user1 = userService.saveUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user1);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<User> getSingle(@PathVariable String userId) {
    User user = userService.getUser(userId);
    return ResponseEntity.ok(user);
  }

  @DeleteMapping("/{userId}")
  public void deleteUser(@PathVariable("userId") String userId) {
    this.userService.delUser(userId);
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> allUser = userService.getAll();
    return ResponseEntity.ok(allUser);
  }
}
