package com.keasperchat.authentification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keasperchat.authentification.dao.UserDao;
import com.keasperchat.authentification.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public User findById(long id) {
		Optional<User> user = userDao.findById(id);
		if(user.isPresent())return user.get();
		return null;
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
	
	//ajouter la verification de tous les champs
	//
	public boolean delete (Long id) {
		Optional<User> response = userDao.findById(id);
		if(response.isPresent() == true && response.get() !=null  ) {
		userDao.deleteById(id);
		return true;
		}else return  false;
	}

}
