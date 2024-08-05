package com.application.Assginment.JPA;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.Assginment.model.User;

@Repository
public interface UserJapRepostitry extends JpaRepository<User, Long>{

	@Query("from User as u where u.emailId =:emailId")
	User findbyUsername(@RequestParam("emailId") String emailId);

	Optional<User> findById(Long customerId1);

}
