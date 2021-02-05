package com.keasper.authentication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keasper.authentication.repository.UserRepository;
import com.keasper.authentication.exceptions.NoDataFoundException;
import com.keasper.authentication.exceptions.UserNotFoundException;
import com.keasper.authentication.model.User;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll(){
		List<User> users = userRepository.findAll();
		if(users.isEmpty()) throw new NoDataFoundException();
		else return users;
	}

	public User findById(long id) {
		
		return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
	}
	public User findBySurname(String Surname) {
		
		return Optional.of(userRepository.findBySurname(Surname)).orElseThrow(()-> new UserNotFoundException("name", Surname));
	}

	public User findByName(String name) {
		
		return Optional.of(userRepository.findByName(name)).orElseThrow(()-> new UserNotFoundException("name", name));
	}

	public User save (User user) {
		return userRepository.save(user);
	}

	public User update(User user) {
		User userUpdate = this.findById(user.getId());
		if (userUpdate!=null) {
			userUpdate.setSurname(user.getSurname());
			userUpdate.setName(user.getName());
			userUpdate.setEmail(user.getEmail());
			return this.save(userUpdate);
		}
		return null;
	}

	
	public boolean delete (Long id) {
		if(this.findById(id)!=null) { userRepository.deleteById(id);return true;}
		else return false;
	}

}
