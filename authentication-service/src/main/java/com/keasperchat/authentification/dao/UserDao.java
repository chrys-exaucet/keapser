package com.keasperchat.authentification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keasperchat.authentification.model.User;


@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByFirstname(String firstname);
	User findByLastname(String lastname);
	
}
