package com.masato.springbootjwt.service;

import com.masato.springbootjwt.entity.User;
import java.util.List;

public interface UserService {
  User findByUsername(String username);

  List<User> findAllUsers();
}
