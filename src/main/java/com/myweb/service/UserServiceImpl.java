package com.myweb.service;

import java.util.ArrayList;
import java.util.List;
import com.myweb.domain.ViewUser;

public class UserServiceImpl implements UserService{

	@Override
	public List<ViewUser> getAllRegisteredUser() {
		// TODO Auto-generated method stub
		List<ViewUser> userList = new ArrayList<ViewUser>();
		ViewUser user1 = new ViewUser(1,"Tom");
		ViewUser user2 = new ViewUser(1,"Jack");
		userList.add(user1);userList.add(user2);
		return userList;
	}

}
