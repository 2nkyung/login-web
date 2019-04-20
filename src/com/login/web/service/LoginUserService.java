package com.login.web.service;

import java.util.List;

import com.login.web.vo.LoginUserVO;

public interface LoginUserService {

	public List<LoginUserVO> selectLoginUserList(LoginUserVO lu);
	public LoginUserVO LoginUser(LoginUserVO lu);
	public int insertLoginUser(LoginUserVO lu);
	public int updateLoginUser(LoginUserVO lu);
	public int deleteLoginUser(int luNum);
	
}
