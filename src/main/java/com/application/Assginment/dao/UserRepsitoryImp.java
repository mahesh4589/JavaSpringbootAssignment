package com.application.Assginment.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.Assginment.JPA.UserJapRepostitry;
import com.application.Assginment.model.User;

@Repository(value = "UserRepository")
public class UserRepsitoryImp implements UserRepositoryDao {

	@Autowired
	UserJapRepostitry userJapRepostitry;

	@Override
	public boolean createUser(User user) {
		try {
			userJapRepostitry.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public User getUserInfoByUsername(String emailId) {
		User userinfo = null;
		try {
			userinfo = userJapRepostitry.findbyUsername(emailId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userinfo;

	}

	@Override
	public Optional<User> findById(Long id) {
		Optional<User> userinfo = null;
		try {
			 userinfo = userJapRepostitry.findById( id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userinfo; 
	}
}
