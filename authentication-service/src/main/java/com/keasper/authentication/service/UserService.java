package com.keasper.authentication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keasper.authentication.repository.UserRepository;
import com.keasper.authentication.model.User;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}
	public User findByFirstName(String firstname) {
		return userRepository.findByFirstname(firstname);
	}
	
	public User findByLastName(String lastname) {
		return  userRepository.findByLastname(lastname);
	}
	
	public User save (User user) {
		return userRepository.save(user);
	}
	
	public User update(User user) {
		Optional<User> userUpdate = userRepository.findById(user.getId());
		if (userUpdate.isPresent()) {
			User userKeep = userUpdate.get();
			userKeep.setFirstname(user.getFirstname());
			userKeep.setLastname(user.getLastname());
			userKeep.setEmail(user.getEmail());
			return this.save(userKeep);
		}
		return null;
	}
	
	//ajouter la verification de tous les champs
	//
	public boolean delete (Long id) {
		Optional<User> response = userRepository.findById(id);
		if(response.isPresent() == true && response.get() !=null  ) {
		userRepository.deleteById(id);
		return true;
		}else return  false;
	}

}
