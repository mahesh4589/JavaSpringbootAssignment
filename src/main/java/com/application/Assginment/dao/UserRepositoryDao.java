package com.application.Assginment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.Assginment.model.User;

public interface UserRepositoryDao  {

	boolean createUser(User user);

	@Query("from User as u where u.emailId =:emailId")
	User getUserInfoByUsername(@RequestParam("emailId")String userName);

	Optional<User> findById(Long id);

}
