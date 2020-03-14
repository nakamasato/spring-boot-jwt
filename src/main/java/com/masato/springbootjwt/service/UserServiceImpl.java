package com.masato.springbootjwt.service;

import com.masato.springbootjwt.entity.User;
import com.masato.springbootjwt.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired private UserRepository userRepository;

  @Override
  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public List<User> findAllUsers() {
    return (List<User>) userRepository.findAll();
  }
}
