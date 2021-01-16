package com.keasperchat.authentification.service;

import com.keasperchat.authentification.dao.UserDao;
import com.keasperchat.authentification.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	private final UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public User findById(long id) {
		Optional<User> user = userDao.findById(id);
		return user.orElse(null);
	}
	public User findByFirstName(String firstname) {
		return userDao.findByFirstname(firstname);
	}
	
	public User findByLastName(String lastname) {
		return  userDao.findByLastname(lastname);
	}
	
	public User save (User user) {
		return userDao.save(user);
	}
	
	public User update(User user) {
		Optional<User> userUpdate = userDao.findById(user.getId());
		if (userUpdate.isPresent()) {
			User userKeep = userUpdate.get();
			userKeep.setFirstname(user.getFirstname());
			userKeep.setLastname(user.getLastname());
			userKeep.setEmail(user.getEmail());
			return this.save(userKeep);
		}
		return null;
	}
	
	// TODO: ajouter la verification de tous les champs
	//
	public boolean delete (Long id) {
		Optional<User> response = userDao.findById(id);
		if(response.isPresent()) {
		userDao.deleteById(id);
		return true;
		}else return  false;
	}

}
