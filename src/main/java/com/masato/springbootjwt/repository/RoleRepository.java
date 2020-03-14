package com.masato.springbootjwt.repository;

import com.masato.springbootjwt.entity.Role;
import com.masato.springbootjwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
