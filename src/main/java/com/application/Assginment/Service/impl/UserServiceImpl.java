package com.application.Assginment.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.application.Assginment.Service.UserService;
import com.application.Assginment.dao.UserRepositoryDao;
import com.application.Assginment.dto.LoginDto;
import com.application.Assginment.dto.UserDto;
import com.application.Assginment.dto.responce.UserInfoDto;

import com.application.Assginment.model.User;

@Service(value = "UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepositoryDao repositoryDao;

	@Override
	public boolean createUser(UserDto userDto) {
		User user = new User();
		user.setEmailId(userDto.getEmailId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setPhNo(userDto.getPhNo());
		return repositoryDao.createUser(user);
	}

	@Override
	public UserInfoDto userLoginService(LoginDto user) {
		User userinfo = repositoryDao.getUserInfoByUsername(user.getUserName());
		UserInfoDto userdto = new UserInfoDto();
		if (userinfo.getEmailId() == null) {
			userdto.setMassages("UserNot found");
			userdto.setStatusCode(HttpStatus.NOT_FOUND.value());
		} else if (!userinfo.getEmailId().equals(user.getUserName())) {
			userdto.setStatusCode(HttpStatus.NOT_FOUND.value());
			userdto.setMassages("User Not found");
		}
		if (userinfo.getPassword().equals(user.getPassword())) {
			userdto.setStatusCode(HttpStatus.OK.value());
			userdto.setMassages("user login sucessfully ..!");
			userdto.setUserId(userinfo.getId());
		} else {
			userdto.setStatusCode(HttpStatus.BAD_REQUEST.value());
			userdto.setMassages("Check Username and password");

		}
		return userdto;
	}

}
