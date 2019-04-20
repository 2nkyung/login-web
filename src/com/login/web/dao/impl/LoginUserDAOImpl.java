package com.login.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.web.common.DBConnector;
import com.login.web.dao.LoginUserDAO;
import com.login.web.vo.LoginUserVO;

public class LoginUserDAOImpl implements LoginUserDAO {

	private static String selectListSql = "select * from login_user where 1=1";
	//private static String selectSql = selectListSql + " and lu_num=?"; // 하나밖에 안나온다는 가정을 해야한다
	private static String selectSql = selectListSql + " and lu_id=? and lu_pwd=?"; //아이디 유니크로 만들고 num을 id로 변경
	//조건문 pwd 추가, 아이디 비밀번호를 같이 확인해서 로그인
	
	@Override
	public List<LoginUserVO> selectLoginUserList(LoginUserVO lu) {
		try (Connection con = DBConnector.getCon(); PreparedStatement ps = con.prepareStatement(selectListSql);) {
			ps.setString(1, lu.getLuId());
			ps.setString(2, lu.getLuPwd());
			ResultSet rs = ps.executeQuery();
			List<LoginUserVO> userList = new ArrayList<>();
			while (rs.next()) {
				LoginUserVO luv = new LoginUserVO();
				luv.setLuId(rs.getString("lu_id")); // 겟스트링(컬럼명)
				luv.setLuName(rs.getString("lu_name"));
				luv.setLuNum(rs.getInt("lu_num"));
				luv.setLuPwd(rs.getString("lu_pwd"));
				userList.add(luv);
				// 와일문 안에 리턴 리스트가있으면 백개가있던 천개가있던 와일문 한번만 돌고 끝남
			}
			return userList;
		} catch (SQLException e) {

		} finally {
			DBConnector.close();
		}
		return null;
	}

	@Override
	public LoginUserVO selectLoginUser(LoginUserVO lu) {
		try (Connection con = DBConnector.getCon(); PreparedStatement ps = con.prepareStatement(selectSql);) {
			//ps.setInt(1, lu.getLuNum());
			ps.setString(1, lu.getLuId());
			ps.setString(2, lu.getLuPwd());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				LoginUserVO luv = new LoginUserVO();
				luv.setLuId(rs.getString("lu_id"));
				luv.setLuName(rs.getString("lu_name"));
				luv.setLuNum(rs.getInt("lu_num"));
				luv.setLuPwd(rs.getString("lu_pwd"));
				return luv; //하나만 조회하기 때문에 이프문 안에 리턴해도 됨
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	public static void main(String[] args) {
		LoginUserDAO ludao = new LoginUserDAOImpl();
		System.out.println(ludao.selectLoginUserList(null));
		LoginUserVO lu = new LoginUserVO();
		lu.setLuId("pink");
		System.out.println(ludao.selectLoginUser(lu));
		lu = new LoginUserVO();
		lu.setLuId("pink");
		lu.setLuPwd("1234");
		LoginUserVO tmpLu = ludao.selectLoginUser(lu);
		if(tmpLu!=null) {
			System.out.println("로그인 성공!");
		}else {
			System.out.println("아이디나 비밀번호를 확인해주세요!");
		}
	}
}

//비투씨 서비스를 제공하는건 회사 사용하는건 사용자
//비투비 회사대 회사 (쿠팡에서 물건샀을 때 택배조회)
