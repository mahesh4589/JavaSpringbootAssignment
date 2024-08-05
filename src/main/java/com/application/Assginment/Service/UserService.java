package com.application.Assginment.Service;

import com.application.Assginment.dto.LoginDto;
import com.application.Assginment.dto.UserDto;
import com.application.Assginment.dto.responce.UserInfoDto;


public interface UserService {

	boolean createUser(UserDto userDto);

	UserInfoDto userLoginService(LoginDto user);

}
