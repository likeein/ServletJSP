package com.ssamz.biz.user;

import java.util.List;

public class SelectUserTest3 {

	public static void main(String[] args) {

		UserDAO dao = new UserDAO();
		
		List<UserVO> userList = dao.getUserList();
		
		System.out.println("[ USER 목록 ]");
		System.out.println("전체 회원의 수 : " + userList.size());
		
		System.out.println("[ 회원의 권한 ]");
		for(UserVO user : userList) {
			System.out.println(user.getName() + "의 권한 : " + user.getRole());
		}
		
		dao.getUserList();
	}

}
