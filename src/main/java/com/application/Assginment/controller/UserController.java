package com.application.Assginment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Assginment.Service.UserService;
import com.application.Assginment.dto.LoginDto;
import com.application.Assginment.dto.UserDto;
import com.application.Assginment.dto.responce.UserCreateResDto;
import com.application.Assginment.dto.responce.UserInfoDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/user/register")
	ResponseEntity<UserCreateResDto> createUser(@RequestBody UserDto user) {
		UserCreateResDto dto = new UserCreateResDto();
		boolean flag = userService.createUser(user);
		if (flag) {
			dto.setMassages("User Create Scuesfully... ");
			dto.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<UserCreateResDto>(dto,HttpStatus.CREATED);
		} else {
			dto.setMassages("User Not Create..");
			dto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<UserCreateResDto>(dto,HttpStatus.BAD_REQUEST);
		}

	}

	@SuppressWarnings("null")
	@PostMapping("/user/login")
	ResponseEntity<UserInfoDto> userLoginService(@RequestBody LoginDto user, HttpServletRequest request) {
		UserInfoDto userinfo = userService.userLoginService(user);
		if (userinfo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userinfo.getUserId());
			return new ResponseEntity<UserInfoDto>(userinfo, HttpStatus.OK);
		} else {
			userinfo.setMassages("UserName and Password Invalid...!");
			return new ResponseEntity<UserInfoDto>(userinfo, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/logout")
	public ResponseEntity<UserInfoDto> userLoggedOut(HttpServletRequest request) {
		UserInfoDto userInfo = new UserInfoDto();
		HttpSession session = request.getSession();
		session.invalidate();
		userInfo.setMassages("User Logged Out Sucessfully...!");
		userInfo.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<UserInfoDto>(userInfo, HttpStatus.OK);
	}

}
