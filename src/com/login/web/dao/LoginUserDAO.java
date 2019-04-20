package com.login.web.dao;

import java.util.List;

import com.login.web.vo.LoginUserVO;

public interface LoginUserDAO {

		public List<LoginUserVO> selectLoginUserList(LoginUserVO lu);
		//컬럼이 추가되면 맵에서 키를 추가 
		public LoginUserVO selectLoginUser(LoginUserVO lu);
		public int insertLoginUser(LoginUserVO lu);
		public int updateLoginUser(LoginUserVO lu);
		public int deleteLoginUser(int luNum);
		
}
