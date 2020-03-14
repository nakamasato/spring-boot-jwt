package com.masato.springbootjwt.controller;

import com.masato.springbootjwt.entity.User;
import com.masato.springbootjwt.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springjwt")
public class ResourceController {
  @Autowired private UserService userService;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  @PreAuthorize("hasAuthority('ADMIN_USER')")
  public List<User> getUsers() {
    return userService.findAllUsers();
  }
}
