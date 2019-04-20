package com.login.web.service.impl;

import java.util.List;

import com.login.web.dao.LoginUserDAO;
import com.login.web.dao.impl.LoginUserDAOImpl;
import com.login.web.service.LoginUserService;
import com.login.web.vo.LoginUserVO;

public class LoginUserServiceImpl implements LoginUserService {

	private LoginUserDAO ludao = new LoginUserDAOImpl(); //서비스는 다오에 의존성을 갖고있음
	
	@Override
	public List<LoginUserVO> selectLoginUserList(LoginUserVO lu) {
		return ludao.selectLoginUserList(lu);
	}

	@Override
	public LoginUserVO LoginUser(LoginUserVO lu) {
		// 사용자의 값을 받아서 서비스는 다오한테 넘긴다
		// lu = ludao.selectLoginUser(lu); 이게 널인지 아닌지 바로 구분지을게 아니기때문에 바로 리턴으로 넘긴다
		return ludao.selectLoginUser(lu);
	}

	@Override
	public int insertLoginUser(LoginUserVO lu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLoginUser(LoginUserVO lu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLoginUser(int luNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
