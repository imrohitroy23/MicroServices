package com.example.userService.userService.Services;

import com.example.userService.userService.model.User;
import java.util.List;

public interface UserService {
  public User saveUser(User user);

  public List<User> getAll();

  public User getUser(String userId);

  public void delUser(String userId);
}
