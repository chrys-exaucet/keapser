package com.keasper.authentication.service;

import java.util.List;

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
	public User findByFirstName(String firstname) {
		User user = userRepository.findByFirstname(firstname); 
		if(user!=null) throw new UserNotFoundException("firstname", firstname);
		else return user;
	}
	
	public User findByLastName(String lastname) {
		User user = userRepository.findByFirstname(lastname); 
		if(user!=null) throw new UserNotFoundException("lasttname", lastname);
		else return user;
	}
	
	public User save (User user) {
		return userRepository.save(user);
	}
	
	public User update(User user) {
		User userUpdate = this.findById(user.getId());
		if (userUpdate!=null) {
			userUpdate.setFirstname(user.getFirstname());
			userUpdate.setLastname(user.getLastname());
			userUpdate.setEmail(user.getEmail());
			return this.save(userUpdate);
		}
		return null;
	}
	
	//ajouter la verification de tous les champs
	//
	public boolean delete (Long id) {
		if(this.findById(id)!=null) { userRepository.deleteById(id);return true;}
		else return false;
	}

}
