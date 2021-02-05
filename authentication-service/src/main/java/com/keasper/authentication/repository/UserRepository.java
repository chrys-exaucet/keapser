package com.keasper.authentication.repository;

import com.keasper.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findBySurname(String Surname);
	User findByName(String name);

}
