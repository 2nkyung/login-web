package com.login.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.web.service.LoginUserService;
import com.login.web.service.impl.LoginUserServiceImpl;
import com.login.web.vo.LoginUserVO;

//localhost/user
//localhost/user/1
//localhost/user/13/2342/34/
@WebServlet("/user/*")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginUserService lus = new LoginUserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		response.setContentType("text/html;charset=utf-8"); //프린트라이트 만들기 전에 캐릭터 utf-8로 만들라고 명시
		PrintWriter pw = response.getWriter(); //응답객체에서 프린트라이터를 가져와
		//pw에다가 서버가 하고싶은말을 쓸거거든
		
		if (cmd != null) { //널이 아니면 로그인이 잘 됐다는 거거든
			if ("login".equals(cmd)) {
//로그인 메소드를 호출하려고 하는데 사용자한테 아이디, 비밀번호를 받아와야함
//사용자에게 받을수 있는건 요청주소와 보내려는 키밸류밖에없음. cmd나 url 
				String luId = request.getParameter("luId");
				String luPwd = request.getParameter("luPwd");
				//변형을 해서 서비스가 알아먹도록 바꿔줘야한다. LoginUserVO에 넣어줘야함
				LoginUserVO lu = new LoginUserVO();
				lu.setLuId(luId);
				lu.setLuPwd(luPwd);
				lu = lus.LoginUser(lu);
				if(lu==null) {
				pw.println("로그인 실패");
				}else {
				HttpSession session = request.getSession(); //4가지 스코프 중에서 세션처리
				pw.println(session.getId() + "로그인 성공");	
				}
			//	lu.setLuId("gold1");
			//	lu.setLuPwd("1234"); //여기까진 들어가는데
			//	lu = lus.LoginUser(lu); // gold1 아이디가 없으니 그냥 리턴 널이기 때문에 
			//	System.out.println(lu); //널이 나옴
			}
		}
	}
}
