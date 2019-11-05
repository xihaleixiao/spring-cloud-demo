package com.xhlx.dao;


import com.xhlx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
