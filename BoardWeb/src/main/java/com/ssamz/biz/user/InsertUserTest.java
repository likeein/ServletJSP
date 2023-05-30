package com.ssamz.biz.user;

public class InsertUserTest {

	public static void main(String[] args) {
		
		UserDAO dao = new UserDAO();
		
		UserVO vo = new UserVO();
		vo.setName("쌤즈");
		vo.setRole("USER");
		vo.setId("ssamz4");
		vo.setPasswd("ssamz123");
		dao.insertUser(vo);
		
		dao.getUserList();
		
	}
}
