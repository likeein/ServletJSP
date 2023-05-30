package com.ssamz.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.StartDocument;

import com.ssamz.biz.user.UserDAO;
import com.ssamz.biz.user.UserVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	//1. 사용자 입력 정보 추출
    	String id = request.getParameter("id");
    	String passwd = request.getParameter("passwd");
    	
    	//2. DB 연동 처리
    	UserVO vo = new UserVO();
    	vo.setId(id);
    	
    	UserDAO dao = new UserDAO();
    	UserVO user = dao.getUser(vo);
    	
    	//3. 응답 화면 구성
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	//메시지 출력
    	if(user != null) {
    		if(user.getPasswd().equals(passwd)) {
    			out.println(user.getName() + "님 로그인 환영!<br>");
    			out.println("<a href='/getBoardList.do'>글 목록 이동</a>");
    		}else {
				out.println("비밀번호 오류입니다.<br>");
				out.println("<a href='/'>다시 로그인</a>");
			}
    	}else {
			out.println("아이디 오류입니다.<br>");
			out.println("<a href='/'>다시 로그인</a>");
		}
    	
	}

}
